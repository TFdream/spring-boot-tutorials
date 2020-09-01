package io.dreamstudio.springboot.async.web.controller;

import io.dreamstudio.springboot.async.service.UserService;
import io.dreamstudio.springboot.async.web.ResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.Future;

/**
 * @author Ricky Fung
 */
@RestController
@RequestMapping("/api")
public class AsyncController {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Resource
    private UserService userService;

    @RequestMapping("/future")
    public ResponseDTO doTask() throws Exception {
        LOG.info("测试带返回结果开始");
        Future<String> future = userService.getUserById(15L);
        String result = future.get();
        return ResponseDTO.ok(result);
    }

    @RequestMapping("/void")
    public ResponseDTO doNoReturn() {
        LOG.info("测试不带返回结果开始");
        userService.doNoReturn();
        return ResponseDTO.ok();
    }
}
