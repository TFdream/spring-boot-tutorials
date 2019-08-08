package io.dreamstudio.springboot.dubbo.contracts;

import io.dreamstudio.springboot.dubbo.contracts.dto.UserDTO;

/**
 * @author Ricky Fung
 */
public interface DemoService {

    UserDTO findUserById(Long uid);
}
