package org.example.mvc.controller;

import org.example.mvc.annotation.Controller;
import org.example.mvc.annotation.RequestMapping;
import org.example.mvc.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 어노테이션 기반
@Controller
public class UserListController{

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("users", UserRepository.findAll());
        return "/user/list";
    }
}

// 인터페이스 기반
/*
public class UserListController implements Controller{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("users", UserRepository.findAll());
        return "/user/list";
    }
}*/
