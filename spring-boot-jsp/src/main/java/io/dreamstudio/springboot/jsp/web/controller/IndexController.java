package io.dreamstudio.springboot.jsp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Ricky Fung
 */
@Controller
public class IndexController {

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(name = "userName") String userName) {
        ModelAndView view = new ModelAndView("index");
        view.addObject("userName", userName);
        return view;
    }
}