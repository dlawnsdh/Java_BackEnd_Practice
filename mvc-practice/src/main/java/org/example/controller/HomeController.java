package org.example.controller;

import org.example.annotation.Controller;
import org.example.annotation.RequestMapping;
import org.example.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @Controller 애노테이션이 설정돼 있는 모든 클래스를 찾아서 출력한다.
@Controller
public class HomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(HttpServletRequest request, HttpServletResponse response) {
        return "home";
    }
}
