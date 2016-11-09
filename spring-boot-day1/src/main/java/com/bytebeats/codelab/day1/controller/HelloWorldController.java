package com.bytebeats.codelab.day1.controller;

import com.bytebeats.codelab.day1.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("hello")
    public String hello(@RequestParam String name) {
        return helloWorldService.getHelloMessage(name);
    }
}
