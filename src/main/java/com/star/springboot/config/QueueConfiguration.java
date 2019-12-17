package com.star.springboot.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName QueueConfiguration
 * @Description TODO
 * @Author Administrator
 * @Date 2019/11/19 10:00
 * @Version 1.0
 */
@Configuration
public class QueueConfiguration {

	public static final String QUEUE_NAME = "direct_queue";

	@Bean
	public Queue queue(){
		return new Queue(QUEUE_NAME);
	}

	@Bean
	public MessageConverter messageConverter(){
		return new Jackson2JsonMessageConverter();
	}
}
