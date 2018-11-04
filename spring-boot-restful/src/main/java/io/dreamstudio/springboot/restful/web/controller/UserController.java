package io.dreamstudio.springboot.restful.web.controller;

import io.dreamstudio.springboot.restful.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.dreamstudio.springboot.restful.model.User;
import io.dreamstudio.springboot.restful.web.ApiResult;

/**
 * @author Ricky Fung
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ApiResult<Long> create(@RequestBody User user) {
        Long id = userService.create(user);
        if (id!=null) {
            return ApiResult.buildSuccess(id);
        }
        return ApiResult.buildSysError();
    }

    @GetMapping("/users/{id}")
    public ApiResult<User> getUser(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ApiResult.buildSuccess(user);
    }

}
