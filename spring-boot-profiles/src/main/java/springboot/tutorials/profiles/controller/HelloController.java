package springboot.tutorials.profiles.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.tutorials.profiles.config.DemoConfiguration;
import java.util.HashMap;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 */
@RestController
public class HelloController {

    @Autowired
    private DemoConfiguration demoConfiguration;

    @RequestMapping(value = "/config", method= RequestMethod.GET)
    public Map<String, String> hello() {
        Map<String, String> map = new HashMap<>(4);
        map.put("name", demoConfiguration.getName());
        return map;
    }
}
