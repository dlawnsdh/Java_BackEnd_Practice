package org.example.mvc;

import org.example.mvc.controller.*;

import java.util.HashMap;
import java.util.Map;

// Controller 인터페이스 기반 매핑
public class RequestMappingHandlerMapping implements HandlerMapping {
    // ex) key : /users, value : UserController
    private Map<HandlerKey, Controller> mappings = new HashMap<>();

    void init() {
        //mappings.put(new HandlerKey(RequestMethod.GET, "/"), new HomController());
        //mappings.put(new HandlerKey(RequestMethod.GET, "/users"), new UserListController());
        //mappings.put(new HandlerKey(RequestMethod.POST, "/users"), new UserCreateController());
        //mappings.put(new HandlerKey(RequestMethod.GET, "/user/form"), new ForwardController("/user/form"));
    }

    public Controller findHandler(HandlerKey handlerKey) {
        return mappings.get(handlerKey);
    }
}
