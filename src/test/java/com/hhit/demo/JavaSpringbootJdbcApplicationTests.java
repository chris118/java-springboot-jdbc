package com.hhit.demo;

import com.hhit.demo.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaSpringbootJdbcApplicationTests {

    @Autowired
    private UserService userSerivce;

    @Test
    public void contextLoads() {


    }

    @Test
    public void test() throws Exception {
        // 插入5个用户
        userSerivce.create("a", 1, 1);
        userSerivce.create("b", 2, 2);
        userSerivce.create("c", 3,3 );
        userSerivce.create("d", 4,4 );
        userSerivce.create("e", 5, 5);

        // 查数据库，应该有5个用户
        Assert.assertEquals(5, userSerivce.getAllUsers().intValue());

        // 删除两个用户
        userSerivce.deleteByName("a");
        userSerivce.deleteByName("e");

        // 查数据库，应该有3个用户
        Assert.assertEquals(3, userSerivce.getAllUsers().intValue());

    }

}
