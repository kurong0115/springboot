package com.star.springboot.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @ClassName Article
 * @Description 文章实体类
 * @Author Administrator
 * @Date 2019/11/27 10:23
 * @Version 1.0
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Article implements Serializable {

	@Id
	@javax.persistence.Id
	public Integer id;

	@NotEmpty(message = "作者不能为空")
	private String author;

	@NotEmpty(message = "内容不能为空")
	private String content;
}
