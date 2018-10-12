package com.xd.rabbirmq.te;


import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;


/**
 * 消息接受着
 * <p>
 * RabbitListener : bindings 绑定队列
 *
 * @QueueBinding 绑定队列详细名字
 * @Queue value        配置队列名称
 * autoDelete  是否是可删除的临时队列
 * <p>
 * exchange   配置交换器
 * @Exchange value  交换机名称
 * type   交换器类型
 * key    路由键
 */
@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "${mq.config.queue.sms}", autoDelete = "true"),
                exchange = @Exchange(value = "${mq.config.exchange}", type = ExchangeTypes.FANOUT)
        )
)
public class SmsReceiver {


    /**
     * 接受消息的方法采用队列监听基质
     */
    @RabbitHandler
    public void process(String msg) {
        System.out.println("  ........ SMS  .........    收到消息：" + msg);
    }
}
