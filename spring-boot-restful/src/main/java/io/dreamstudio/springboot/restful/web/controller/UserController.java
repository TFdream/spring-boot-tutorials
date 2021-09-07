package io.dreamstudio.springboot.restful.web.controller;

import io.dreamstudio.springboot.commons.ResponseDTO;
import io.dreamstudio.springboot.restful.model.User;
import io.dreamstudio.springboot.restful.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ricky Fung
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseDTO<Long> create(@RequestBody User user) {
        Long id = userService.create(user);
        if (id!=null) {
            return ResponseDTO.ok(id);
        }
        return ResponseDTO.systemError();
    }

    @GetMapping("/users/{id}")
    public ResponseDTO<User> getUser(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseDTO.ok(user);
    }

}
