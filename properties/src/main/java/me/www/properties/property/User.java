package me.www.properties.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: www
 * @date: 2018/4/29 23:12
 * @description: TODO
 */
@Component("user")
@ConfigurationProperties(prefix = "user")
public class User {

    private String uname;

    private Integer age;

    private String desc;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", age=" + age +
                ", desc='" + desc + '\'' +
                '}';
    }
}
