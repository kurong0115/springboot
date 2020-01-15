package com.star.springboot.controller;

import com.star.springboot.po.Article;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @ClassName ArticleController
 * @Description 文章控制器
 * @Author Administrator
 * @Date 2020/1/2 10:24
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/article")
public class ArticleController {

	@PostMapping("/saveArticle")
	public Object saveArticle(@Valid Article article, BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			return bindingResult.getAllErrors();
		}
		return article;
	}
}
