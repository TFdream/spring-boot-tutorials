package com.mindflow.springboot.restful.controller;

import com.mindflow.springboot.restful.domain.User;
import com.mindflow.springboot.restful.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 */
@RestController
public class RestfulController {

    @Autowired
    private HelloWorldService helloWorldService;

    @RequestMapping(value = "/user/{id}", method= RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return helloWorldService.getUserById(id);
    }

    @RequestMapping(value = "/hello", method= RequestMethod.GET)
    public String hello(@RequestParam String name) {
        return helloWorldService.getHelloMessage(name);
    }
}
