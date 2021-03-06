package com.xd.rabbirmq;

import com.xd.rabbirmq.te.OrderSender;
import com.xd.rabbirmq.te.ProductSender;
import com.xd.rabbirmq.te.UserSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbirmqApplicationTests {


    @Autowired
    private UserSender userSender;

    @Autowired
    private ProductSender productSender;

    @Autowired
    private OrderSender orderSender;


    @Test
    public void contextLoads() throws Exception {
//        while (true) {
            Thread.sleep(1000);
            userSender.send("hello USER");
            productSender.send("hello PRODUCT");
            orderSender.send("hello OEDER");
//        }
    }


}
