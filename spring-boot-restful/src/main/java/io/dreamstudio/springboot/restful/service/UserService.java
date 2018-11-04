package io.dreamstudio.springboot.restful.service;

import io.dreamstudio.springboot.restful.model.User;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @author Ricky Fung
 */
@Service
public class UserService {

    public User getUserById(Long id){
        User user = new User();
        user.setId(id);
        user.setName("ricky");
        user.setAge(27);
        user.setHobbies(Arrays.asList("NBA", "旅游"));
        return user;
    }

    public Long create(User user) {
        return 1L;
    }
}
