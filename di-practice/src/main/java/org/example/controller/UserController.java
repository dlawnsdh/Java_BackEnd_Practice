package org.example.controller;

import org.example.annnotation.Controller;
import org.example.annnotation.Inject;
import org.example.service.UserService;

@Controller
public class UserController {
    private final UserService userService;

    @Inject
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }
}
