package io.dreamstudio.springboot.lettuce.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Ricky Fung
 */
public class Student implements Serializable {
    private Long id;
    private String name;
    private Date birthday;
    private boolean male;

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }
}
