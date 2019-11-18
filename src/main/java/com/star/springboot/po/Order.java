package com.star.springboot.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @ClassName Order
 * @Description 订单类
 * @Author Administrator
 * @Date 2019/11/15 9:05
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "or_order")
public class Order implements Serializable {



	@Id
	@GeneratedValue
	private Integer id;

	@Column
	private String createTime;

	@Column
	private String updateTime;
}
