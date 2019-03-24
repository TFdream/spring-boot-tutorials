package io.dreamstudio.springboot.thymeleaf.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Ricky Fung
 */
@Controller
public class IndexController {

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(name = "userName") String userName, Model model) {
        model.addAttribute("userName", userName);

        return new ModelAndView("index", "index", model);
    }
}
