package org.example.mvc.controller;

import org.example.mvc.annotation.Controller;
import org.example.mvc.annotation.RequestMapping;
import org.example.mvc.model.User;
import org.example.mvc.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 어노테이션 기반
@Controller
public class UserCreateController{

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        UserRepository.save(new User(request.getParameter("userId"), request.getParameter("name")));
        return "redirect:/users";
    }
}

// 인터페이스 기반
/*
public class UserCreateController implements Controller{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        UserRepository.save(new User(request.getParameter("userId"), request.getParameter("name")));
        return "redirect:/users";
    }
}*/
