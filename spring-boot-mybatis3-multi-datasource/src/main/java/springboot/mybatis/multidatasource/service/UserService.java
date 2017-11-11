package springboot.mybatis.multidatasource.service;

import springboot.mybatis.multidatasource.domain.UserDO;

/**
 * @author Ricky Fung
 */
public interface UserService {

    UserDO getUserByName(String username);

    int insert(UserDO userDO);
}
