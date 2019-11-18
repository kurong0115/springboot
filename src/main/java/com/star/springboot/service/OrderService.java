package com.star.springboot.service;

import com.star.springboot.po.Order;

import java.util.List;

/**
 * @ClassName OrderService
 * @Description 订单接口
 * @Author Administrator
 * @Date 2019/11/15 20:05
 * @Version 1.0
 */
public interface OrderService {

	/**
	 * 拿订单
	 * @param id
	 * @return
	 */
	Order getOrderById(Integer id);

	/**
	 * 更新订单
	 * @param order
	 * @return
	 */
	Order updateOrder(Order order);

    /**
     * 列出所有的订单
     * @return
     */
	List<Order> listAllOrder();
}
