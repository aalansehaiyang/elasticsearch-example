package com.boot;

import com.alibaba.fastjson.JSON;
import com.boot.ch2.Application;
import com.boot.ch2.Car;
import com.boot.ch2.CarConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author onlyone
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class Ch2ApplicationTest {

    @Autowired
    private CarConfig carConfig;

    @Test
    public void m1() {

        List<Car> list = carConfig.getCarList();
        System.out.println(JSON.toJSONString(list));
    }

}
