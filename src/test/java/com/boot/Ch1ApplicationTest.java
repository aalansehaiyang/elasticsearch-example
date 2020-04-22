package com.boot;

import com.boot.ch1.Application;
import com.boot.ch1.Car;
import com.boot.ch1.Driver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.boot.ch1.MyConfig;

/**
 * @author onlyone
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class Ch1ApplicationTest {

    @Autowired
    private Car      car;

    @Autowired
    private Driver   driver;

    @Autowired
    private MyConfig myConfig;

    @Test
    public void contextLoads() {
        boolean result = driver.getCar() == car;
        System.out.println(result ? "同一个car" : "不同的car");

        System.out.println("driver实例中的car：" + driver.getCar());
        System.out.println("spring容器car：" + car);

    }
    // 结果：
    // 不同的car
    // Car(id=1, name=car, version=3)

}
