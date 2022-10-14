package org.example.mvc.controller;

import org.example.mvc.annotation.Controller;
import org.example.mvc.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 어노테이션 기반
@Controller
public class HomController{

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "home";
    }
}

// 인터페이스 기반
/*
public class HomController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "home";
    }
}*/
