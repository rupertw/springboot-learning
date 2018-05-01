package me.www.properties.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author: www
 * @date: 2018/4/29 23:54
 * @description: TODO
 */
@Component
public class ProjectSystem {

    @Value("${runenv}")
    private String runenv;

    public String getRunenv() {
        return runenv;
    }

    public void setRunenv(String runenv) {
        this.runenv = runenv;
    }

    @Override
    public String toString() {
        return "System{" +
                "runenv='" + runenv + '\'' +
                '}';
    }
}
