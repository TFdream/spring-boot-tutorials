package io.dreamstudio.springboot.prometheus.web.controller;

import io.dreamstudio.springboot.commons.ResponseDTO;
import io.dreamstudio.springboot.prometheus.metrics.SampleBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * @author Ricky Fung
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Resource
    private SampleBean sampleBean;
    
    @GetMapping("/index")
    public ResponseDTO get() {
        return ResponseDTO.ok();
    }
    
    @GetMapping("/count")
    public ResponseDTO counter(@RequestParam(value = "message", required = false) String msg) {
        sampleBean.handleMessage(msg);
        return ResponseDTO.ok();
    }
}
