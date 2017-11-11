package springboot.mybatis.xml.controller;

import springboot.mybatis.xml.model.UserDO;
import springboot.mybatis.xml.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-14 17:33
 */
@RestController
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "users/{username}", method= RequestMethod.GET)
    public UserDO getUser(@PathVariable String username) {
        UserDO userDO = userService.getUserByName(username);
        if(userDO==null){
            logger.info("not find user:{}", username);
            userDO = new UserDO();
            userDO.setUsername(username);
            userDO.setPassword("root");
            userDO.setAge(28);
        }
        return userDO;
    }

    @RequestMapping(value = "user/add", method= RequestMethod.GET)
    public UserDO addUser(@RequestParam String username) {
        return userService.addUser(username);
    }
}
