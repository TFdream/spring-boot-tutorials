package springboot.mybatis.multidatasource.service.impl;

import springboot.mybatis.multidatasource.domain.UserDO;
import springboot.mybatis.multidatasource.domain.UserDOExample;
import springboot.mybatis.multidatasource.mapper.master.UserDOMapper;
import springboot.mybatis.multidatasource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author Ricky Fung
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDOMapper userDOMapper;

    @Override
    public UserDO getUserByName(String username) {
        UserDOExample example = new UserDOExample();
        List<UserDO> list = userDOMapper.selectByExample(example);
        if(list==null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public int insert(UserDO userDO) {
        return userDOMapper.insertSelective(userDO);
    }
}
