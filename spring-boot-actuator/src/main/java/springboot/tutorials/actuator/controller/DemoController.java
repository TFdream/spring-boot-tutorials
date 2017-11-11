package springboot.tutorials.actuator.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ricky Fung
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping(value = "/hello", method= RequestMethod.GET)
    public String hello(@RequestParam String name) {
        return "hello "+name;
    }
}
