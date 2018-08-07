package springboot.tutorials.helloworld.web.controller;

import springboot.tutorials.helloworld.domain.User;
import springboot.tutorials.helloworld.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 */
@RestController
public class HelloController {

    @Autowired
    private HelloWorldService helloWorldService;

    @RequestMapping(value = "/user/{id}", method= RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return helloWorldService.getUserById(id);
    }

    @RequestMapping(value = "/hello", method= RequestMethod.GET)
    public String hello(@RequestParam String name) {
        return helloWorldService.getHelloMessage(name);
    }
}
