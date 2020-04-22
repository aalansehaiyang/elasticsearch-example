package com.boot;

import com.boot.ch3.Ch3Application;
import com.onlyone.CustomerCache;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author onlyone
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Ch3Application.class)
public class Ch3ApplicationTest {

    @Autowired(required = false)
    private CustomerCache customerCache;

    @Test
    public void testCache() {
        customerCache.set("k1", "Tom GE");
        String result = customerCache.get("k1");
        System.out.println(result);

    }
}
