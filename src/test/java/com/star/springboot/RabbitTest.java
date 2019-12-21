package com.star.springboot;

import com.star.springboot.message.Consumer;
import com.star.springboot.message.Producer;
import com.star.springboot.po.User;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName RabbitTest
 * @Description TODO
 * @Author Administrator
 * @Date 2019/11/19 10:05
 * @Version 1.0
 */
@SpringBootTest
public class RabbitTest {

	@Autowired
	Producer producer;

	@Autowired
	Consumer consumer;

	@Autowired
	AmqpAdmin amqpAdmin;

	@Autowired
	RabbitTemplate rabbitTemplate;

	@Autowired
	User user;

	@Test
	public void test(){
		rabbitTemplate.convertAndSend("exchange.direct", "direct", user);
	}

	@Test
	public void create(){
		amqpAdmin.declareExchange(new DirectExchange("exchange.direct"));
	}

	@Test
	public void createQueue(){
		amqpAdmin.declareQueue(new Queue("message.queue"));
	}

	@Test
	public void bingQueueAndExchange(){
		amqpAdmin.declareBinding(new Binding("message.queue", Binding.DestinationType.QUEUE, "exchange.direct", "direct", null));
	}


}
