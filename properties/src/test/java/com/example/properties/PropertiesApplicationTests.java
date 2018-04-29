package com.example.properties;

import com.example.properties.property.ProjectSystem;
import com.example.properties.property.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesApplicationTests {

    @Autowired
    private User user;

    @Autowired
    private ProjectSystem projectSystem;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testUser() {
        System.out.println(user);
        return;
    }

    @Test
    public void testProjectSystem() {
        System.out.println(projectSystem);
        return;
    }
}
