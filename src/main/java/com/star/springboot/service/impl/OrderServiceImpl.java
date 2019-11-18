package com.star.springboot.service.impl;

import com.star.springboot.dao.OrderDao;
import com.star.springboot.mapper.OrderMapper;
import com.star.springboot.po.Order;
import com.star.springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @ClassName OrderServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Date 2019/11/15 20:06
 * @Version 1.0
 */
@Service
public class OrderServiceImpl implements OrderService {


	@Autowired
	OrderMapper orderMapper;

	@Cacheable(value = "order")
	@Override
	public Order getOrderById(Integer id) {
		return orderMapper.getOrderById(id);
	}

	@CachePut(value = "order", key = "id")
	@Override
	public Order updateOrder(Order order) {
		return orderMapper.updateOrder(order);
	}
}
