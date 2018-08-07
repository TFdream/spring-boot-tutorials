package springboot.tutorials.mybatis.multidatasource.service;

import springboot.tutorials.mybatis.multidatasource.domain.UserDO;

/**
 * @author Ricky Fung
 */
public interface UserService {

    UserDO getUserByName(String username);

    int insert(UserDO userDO);
}
