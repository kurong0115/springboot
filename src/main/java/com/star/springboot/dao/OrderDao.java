package com.star.springboot.dao;

import com.star.springboot.po.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName OrderDao
 * @Description 定义接口
 * @Author Administrator
 * @Date 2019/11/15 10:31
 * @Version 1.0
 */
@Repository
public interface OrderDao extends JpaRepository<Order, Integer> {

	/**
	 * 找出主键在a、b之间的订单
	 * @param a
	 * @param b
	 * @return
	 */
	List<Order> findOrdersByIdBetween(int a, int b);
}
