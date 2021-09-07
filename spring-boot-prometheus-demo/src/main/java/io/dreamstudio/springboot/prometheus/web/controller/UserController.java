package io.dreamstudio.springboot.prometheus.web.controller;

import io.dreamstudio.springboot.commons.ResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ricky Fung
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/index")
    public ResponseDTO get() {
        return ResponseDTO.ok();
    }
}
