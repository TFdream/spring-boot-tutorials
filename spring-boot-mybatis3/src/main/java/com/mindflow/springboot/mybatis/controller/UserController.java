package com.mindflow.springboot.mybatis.controller;

import com.mindflow.springboot.mybatis.model.User;
import com.mindflow.springboot.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-14 17:33
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "users/{username}", method= RequestMethod.GET)
    public User getUser(@PathVariable String username) {

        return userService.getUserByName(username);
    }

    @RequestMapping(value = "user/add", method= RequestMethod.GET)
    public User addUser(@RequestParam String username) {

        return userService.addUser(username);
    }
}
