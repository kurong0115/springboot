package com.star.springboot.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * @ClassName Article
 * @Description 文章实体类
 * @Author Administrator
 * @Date 2019/11/27 10:23
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article implements Serializable {

	@Id
	public Integer id;
	private String author;
	private String content;
}
