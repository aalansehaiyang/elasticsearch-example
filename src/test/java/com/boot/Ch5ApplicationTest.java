package com.boot;

import com.boot.ch5.Ch5Application;
import com.boot.ch5.OsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author onlyone
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Ch5Application.class)
public class Ch5ApplicationTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void m1() {
        OsService osService = applicationContext.getBean(OsService.class);
        System.out.println(osService.service());
    }
}
