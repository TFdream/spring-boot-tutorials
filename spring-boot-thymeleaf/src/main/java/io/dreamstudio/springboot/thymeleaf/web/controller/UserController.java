package io.dreamstudio.springboot.thymeleaf.web.controller;

import io.dreamstudio.springboot.thymeleaf.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ricky Fung
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping("/list")
    public String listUser(@RequestParam(name = "pageSize") Integer pageSize, Model model) {
        List<User> userList = new ArrayList<>(pageSize);
        for (int i = 0; i <10; i++) {
            User user = new User();
            user.setId(Long.valueOf(i+1));
            user.setName("Ricky");
            user.setAge(28+i);
            user.setAddress("北京市朝阳区");
            userList.add(user);
        }

        model.addAttribute("users", userList);
        return "/user/list";
    }

    @GetMapping("/{id}")
    public String  getUser(@PathVariable Integer id, Model model) {
        User user = new User();
        user.setId(Long.valueOf(id));
        user.setName("Ricky");
        user.setAge(28+id);
        user.setAddress("北京市朝阳区");

        model.addAttribute("user", user);
        return "/user/detail";
    }
}
