package io.dreamstudio.springboot.swagger2.model;

/**
 * @author Ricky Fung
 */
public class UserBio {
    private Long id;
    private String intro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
