package springboot.mybatis.xml.service;

import springboot.mybatis.xml.model.UserDO;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 */
public interface UserService {

    UserDO getUserByName(String username);

    UserDO addUser(String username);
}
