package com.star.springboot.message;

import com.star.springboot.config.QueueConfiguration;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName Consumer2
 * @Description 消费者
 * @Author Administrator
 * @Date 2019/11/19 11:08
 * @Version 1.0
 */
@Component
@RabbitListener(queues = QueueConfiguration.QUEUE_NAME)
public class Consumer2 {

	@Autowired
	RabbitTemplate rabbitTemplate;

	@RabbitHandler
	public void recevie(String msg){
		System.out.println(this.getClass().getSimpleName() + "接受一个消息,内容为" + msg);
	}
}
