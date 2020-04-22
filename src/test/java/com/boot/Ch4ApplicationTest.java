package com.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.boot.ch4.Ch4Application;
import com.boot.ch4.HandlerContext;
import com.boot.ch4.IOrderService;

/**
 * @author onlyone
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Ch4Application.class)
public class Ch4ApplicationTest {

    @Autowired(required = false)
    private HandlerContext handlerContext;

    @Test
    public void m1() {
        String type = "1";
        IOrderService orderService = handlerContext.getInstanceByType(type);
        System.out.println(orderService.handle(type));
    }
}
