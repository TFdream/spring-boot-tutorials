package io.dreamstudio.springboot.swagger2.service;

import io.dreamstudio.springboot.swagger2.model.Address;
import io.dreamstudio.springboot.swagger2.model.User;
import io.dreamstudio.springboot.swagger2.model.UserBio;
import io.dreamstudio.springboot.swagger2.web.vo.ApiResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ricky Fung
 */
@Service
public class UserService {

    public User getUserById(Long id) {
        User user = new User();
        user.setId(id);
        user.setName("ricky");
        user.setPassword("123");
        return user;
    }

    public List<Address> getUserAddressList(Long userId) {
        List<Address> list = new ArrayList<>();
        for (int i=0; i<3; i++) {
            Address address = new Address();
            address.setProvince("北京");
            address.setCity("北京市");
            address.setStreet("朝阳区");
            address.setDetail("银河SOHO");

            list.add(address);
        }
        return list;
    }

    public UserBio getUserBio(Long id) {
        UserBio bio = new UserBio();
        bio.setId(id);
        bio.setIntro("intro");
        return bio;
    }
}
