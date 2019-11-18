package com.star.springboot.mapper;

import com.star.springboot.po.Order;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName OrderMapper
 * @Description 订单接口
 * @Author Administrator
 * @Date 2019/11/15 9:04
 * @Version 1.0
 */
public interface OrderMapper {

	/**
	 * 根据主键查询订单信息
	 * @param id
	 * @return
	 */
	@Select("select * from or_order where id=#{id}")
	Order getOrderById(@RequestParam("id") Integer id);

	/**
	 * 更新订单信息
	 * @param order
	 * @return
	 */
	@Update("update or_order set create_time = 12345 where id = #{id}")
	int updateOrder(Order order);
}
