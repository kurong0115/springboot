package com.star.springboot.controller;

import com.star.springboot.dao.OrderDao;
import com.star.springboot.mapper.OrderMapper;
import com.star.springboot.po.Order;
import com.star.springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName OrderController
 * @Description TODO
 * @Author Administrator
 * @Date 2019/11/15 9:31
 * @Version 1.0
 */
@RestController
public class OrderController {

	@Autowired
	OrderService orderService;

	@Autowired
	OrderDao orderDao;

	@GetMapping("/order/{id}")
	public Object order(@PathVariable("id") Integer id){
		return orderService.getOrderById(id);
	}

    @GetMapping("/update")
    public Object updateOrder(@RequestBody Order order){
        return orderService.updateOrder(order);
    }
}
