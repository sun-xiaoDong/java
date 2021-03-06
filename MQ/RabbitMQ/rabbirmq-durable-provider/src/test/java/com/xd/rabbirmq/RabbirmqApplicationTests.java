package com.xd.rabbirmq;

import com.xd.rabbirmq.te.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbirmqApplicationTests {


    @Autowired
    private Sender sender;

    @Test
    public void contextLoads() throws Exception {
        while (true) {
            Thread.sleep(1000);
            sender.send("hello INFO");
        }
    }

    @Test
    public void contextLoads1() throws Exception {
        int flog = 0;
        while (true) {
            flog++;
            Thread.sleep(2000);
            sender.sendError("hello ERROR" + flog);
        }
    }

 }
