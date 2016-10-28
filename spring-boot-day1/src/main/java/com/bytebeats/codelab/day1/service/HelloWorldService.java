package com.bytebeats.codelab.day1.service;

import org.springframework.stereotype.Service;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2016-10-28 16:18
 */
@Service("helloWorldService")
public class HelloWorldService {

    public String getHelloMessage(String name) {
        return "Hello " + name;
    }
}
