package com.mindflow.springboot.restful.service;

import com.mindflow.springboot.restful.domain.User;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2016-10-28 16:18
 */
@Service("helloWorldService")
public class HelloWorldService {

    public User getUserById(Long id){
        User user = new User();
        user.setId(id);
        user.setName("ricky");
        user.setAge(27);
        user.setHobbies(Arrays.asList("NBA", "旅游"));
        return user;
    }

    public String getHelloMessage(String name) {
        return "Hello " + name;
    }
}
