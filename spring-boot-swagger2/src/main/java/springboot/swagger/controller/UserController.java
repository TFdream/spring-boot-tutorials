package springboot.swagger.controller;

import springboot.swagger.domain.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2017-01-02 23:41
 */
@RestController
@RequestMapping("/demo")
public class UserController {

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "java.lang.Long", name = "id", value = "id", required = true, paramType = "path"),
            @ApiImplicitParam(dataType = "User", name = "user", value = "用户信息", required = true)
    })
    @RequestMapping(value = "/user/{id}",method = RequestMethod.POST)
    public User insert(@PathVariable Long id, @RequestBody User user){

        System.out.println("id:"+id+", user:"+user);
        user.setId(id);

        return user;
    }

    @ApiOperation(value="获取指定id用户详细信息", notes="根据user的id来获取用户详细信息")
    @ApiImplicitParam(name = "id",value = "用户id", dataType = "String", paramType = "path")
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id){

        User user = new User();
        user.setId(id);
        user.setPassword("abc");
        user.setUsername("12345");
        return user;
    }

    @ApiOperation(value="获取所有用户详细信息", notes="获取用户列表信息")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUserList(){

        List<User> list = new ArrayList<>();
        User user = new User();
        user.setId(15L);
        user.setPassword("ricky");
        user.setUsername("root");

        list.add(user);

        return list;
    }

    @ApiIgnore
    @ApiOperation(value="删除指定id用户", notes="根据id来删除用户信息")
    @ApiImplicitParam(name = "id",value = "用户id", dataType = "java.lang.Long", paramType = "path")
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable Long id){
        System.out.println("delete user:"+id);
        return "OK";
    }
}
