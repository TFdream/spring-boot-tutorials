package io.dreamstudio.springboot.swagger2.web.controller;

import io.dreamstudio.springboot.swagger2.model.Address;
import io.dreamstudio.springboot.swagger2.model.User;
import io.dreamstudio.springboot.swagger2.model.UserBio;
import io.dreamstudio.springboot.swagger2.service.UserService;
import io.dreamstudio.springboot.swagger2.web.vo.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Ricky Fung
 */
@RestController
@RequestMapping("/api/users")
@Api("User API")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource(name = "userService")
    private UserService userService;

    @ApiOperation(value = "根据id查询用户信息", notes = "查询数据库中某个用户的信息")
    @ApiImplicitParam(name = "id", value = "用户ID", paramType = "path", required = true, dataType = "java.lang.Long")
    @GetMapping(value = "/{id}")
    public ApiResult<User> getStudent(@PathVariable Long id) {
        logger.info("开始查询某个用户的信息");
        User user = userService.getUserById(id);
        return ApiResult.buildSuccessResult(user);
    }

    @ApiIgnore
    @ApiOperation(value="查询指定id用户bio", notes="根据用户id来查询用户bio信息")
    @ApiImplicitParam(name = "id",value = "用户id", dataType = "java.lang.Long", paramType = "path")
    @GetMapping(value = "/{id}/bio")
    public ApiResult<UserBio> getUserBio(@PathVariable Long id){
        System.out.println("delete user:"+id);

        UserBio bio = userService.getUserBio(id);
        return ApiResult.buildSuccessResult(bio);
    }

    @ApiOperation(value="获取所有用户详细信息", notes="获取用户列表信息")
    @ApiImplicitParam(name = "id", value = "用户ID", paramType = "path", required = true, dataType = "java.lang.Long")
    @GetMapping(value = "/{userId}/address")
    public ApiResult<List<User>> getUserList(@PathVariable Long userId){
        logger.info("开始查询某个用户的收货地址信息");
        List<Address> addressList = userService.getUserAddressList(userId);
        return ApiResult.buildSuccessResult(addressList);
    }

}
