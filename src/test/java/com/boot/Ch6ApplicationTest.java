package com.boot;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.boot.ch6.Ch6Application;
import com.boot.ch6.PersonConfig;

/**
 * @author onlyone
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Ch6Application.class)
public class Ch6ApplicationTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void m1() {
        PersonConfig personConfig = applicationContext.getBean(PersonConfig.class);
        System.out.println(JSON.toJSONString(personConfig));
    }
}
