package com.jsjchai.springboot.demo;

import com.jsjchai.springboot.demo.model.User;
import com.jsjchai.springboot.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {

        try {
            int count = 3000;

            AtomicInteger j = new AtomicInteger();

            CountDownLatch latch = new CountDownLatch(count);
            for ( int i = 0; i < count ; i++) {
                new Thread(()->{
                    long st = System.currentTimeMillis();
                    User user = userService.getById(new Random().nextLong());
                    long end = System.currentTimeMillis() - st;
                    if(end > 1000){
                       j.getAndIncrement();
                    }
                    latch.countDown();
                }).start();

            }

            latch.await();

            System.out.println(j);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}

