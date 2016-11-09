package com.bytebeats.codelab.day1.controller;

import com.bytebeats.codelab.day1.domain.User;
import com.bytebeats.codelab.day1.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2016-10-28 16:14
 */
@RestController
@RequestMapping("/spring-boot")
public class HelloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;

    @RequestMapping(value = "user/{id}", method= RequestMethod.GET)
    public User getUser(@PathVariable Long id) {

        return helloWorldService.getUserById(id);
    }

    @RequestMapping(value = "hello", method= RequestMethod.GET)
    public String hello(@RequestParam String name) {

        return helloWorldService.getHelloMessage(name);
    }
}
