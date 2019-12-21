package com.star.springboot.message;

import com.star.springboot.config.QueueConfiguration;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Queue;

/**
 * @ClassName Producer
 * @Description 消息生产者
 * @Author Administrator
 * @Date 2019/11/19 9:53
 * @Version 1.0
 */
@Component
public class Producer {

	@Autowired
	RabbitTemplate rabbitTemplate;

	public void send(){
		try {
			for (int i = 0; i < 50; i++){
				System.out.println(this.getClass().getSimpleName() + "发送一个消息,内容为" + "Hello World, Direct!" + "---->" + i);
				Thread.sleep(200);
				rabbitTemplate.convertAndSend(QueueConfiguration.QUEUE_NAME, "Hello World, Direct!" + "---->" + i);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
