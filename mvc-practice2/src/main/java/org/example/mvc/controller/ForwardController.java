package org.example.mvc.controller;

import org.example.mvc.annotation.Controller;
import org.example.mvc.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 어노테이션 기반
@Controller
public class ForwardController {

    @RequestMapping(value = "/user/form", method = RequestMethod.GET)
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "form";
    }
}

// 인터페이스 기반
/*
public class ForwardController implements Controller{
    private final String forwardUriPath;

    public ForwardController(String forwardUriPath) {
        this.forwardUriPath = forwardUriPath;
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return forwardUriPath;
    }
}*/
