package org.example.mvc;

import org.apache.catalina.LifecycleState;
import org.example.mvc.controller.Controller;
import org.example.mvc.controller.RequestMethod;
import org.example.mvc.view.JspViewResolver;
import org.example.mvc.view.ModelAndView;
import org.example.mvc.view.View;
import org.example.mvc.view.ViewResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);

    private List<HandlerMapping> handlerMappings;
    private List<HandlerAdapter> handlerAdapters;
    private List<ViewResolver> viewResolvers;

    //private RequestMappingHandlerMapping rmhm; // Controller 인터페이스 기반 매핑

    @Override
    public void init() throws ServletException {
        //RequestMappingHandlerMapping rmhm = new RequestMappingHandlerMapping();
        //rmhm.init();

        AnnotationHandlerMapping ahm = new AnnotationHandlerMapping("org.example");
        ahm.initialize();

        //handlerMappings = List.of(rmhm, ahm);

        handlerMappings = List.of(ahm);
        handlerAdapters = List.of(new SimpleControllerHandlerAdapter(), new AnnotationHandlerAdapter());
        viewResolvers = Collections.singletonList(new JspViewResolver());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("[DispatcherServlet] service started");

        String requestUri = request.getRequestURI();
        RequestMethod requestMethod = RequestMethod.valueOf(request.getMethod());

        try {
            // 어노테이션 기반 실행 코드
            Object handler = handlerMappings.stream()
                    .filter(hm -> hm.findHandler(new HandlerKey(requestMethod, requestUri)) != null)
                    .map(hm -> hm.findHandler(new HandlerKey(requestMethod, requestUri)))
                    .findFirst()
                    .orElseThrow(() -> new ServletException("No handler for [" + requestMethod + ", " + requestUri + "]"));

            HandlerAdapter handlerAdapter = handlerAdapters.stream()
                    .filter(ha -> ha.supports(handler))
                    .findFirst()
                    .orElseThrow(() -> new ServletException("No adapter for handler [" + handler + "]"));

            ModelAndView modelAndView = handlerAdapter.handle(request, response, handler);

            for (ViewResolver viewResolver : viewResolvers) {
                View view = viewResolver.resolveView(modelAndView.getViewName());
                view.render(modelAndView.getModel(), request, response);
            }

            // Controller 인터페이스 기반 실행 코드
            /*
            Controller handler = rmhm.findHandler(new HandlerKey(requestMethod, requestUri));

            String viewName = handler.handleRequest(request, response);

            for (ViewResolver viewResolver : viewResolvers) {
                View view = viewResolver.resolveView(viewName);
                view.render(new HashMap<>(), request, response);
            }*/

        } catch (Exception e) {
            logger.error("exception occurred : [{}]", e.getMessage(), e);
            throw new ServletException(e);
        }
    }
}
