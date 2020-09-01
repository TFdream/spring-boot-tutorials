package io.dreamstudio.springboot.jsp.web.controller;

import io.dreamstudio.springboot.jsp.web.vo.UserVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author Ricky Fung
 */
@RestController
@RequestMapping("/api/demo")
public class DateController {

    @GetMapping("/hello")
    public UserVO hello() {
        UserVO userVO = new UserVO();
        userVO.setId(1l);
        userVO.setName("ricky");
        userVO.setBirthday(new Date());
        return userVO;
    }
}
