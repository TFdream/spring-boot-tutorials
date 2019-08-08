package io.dreamstudio.springboot.redis.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * @author Ricky Fung
 */
public class UserDTO {
    private Long id;
    private String name;
    private String address;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
