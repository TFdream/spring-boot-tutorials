package io.dreamstudio.springboot.restful.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ricky Fung
 */
@RestController
public class HealthController {

    @GetMapping("/health")
    public Map<String, String> health() {
        Map<String, String> map = new HashMap<>(4);
        map.put("status", "200");
        return map;
    }
}
