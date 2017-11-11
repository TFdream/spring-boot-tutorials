package springboot.mybatis.multidatasource.controller;

import springboot.mybatis.multidatasource.domain.UserDO;
import springboot.mybatis.multidatasource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Ricky Fung
 */
@RestController
public class UserController {
    private AtomicInteger counter = new AtomicInteger(1);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users/{username}", method= RequestMethod.GET)
    public UserDO getUser(@PathVariable String username) {
        UserDO userDO = userService.getUserByName(username);
        return userDO;
    }

    @RequestMapping(value = "/user/add", method= RequestMethod.GET)
    public UserDO addUser(@RequestParam String username) {
        UserDO userDO = new UserDO();
        userDO.setUsername(username);
        userDO.setPassword("root");
        userDO.setAge(28);
        userDO.setMobile("186111111");
        userDO.setEmail(String.format("ricky_%d@163.com", counter.getAndIncrement()));
        userDO.setRegistyTime(new Date());
        userDO.setCreateTime(new Date());
        userDO.setModifyTime(new Date());
        userService.insert(userDO);
        return userDO;
    }

}
