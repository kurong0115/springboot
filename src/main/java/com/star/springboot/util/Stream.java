package com.star.springboot.util;

import com.star.springboot.po.Article;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @ClassName Stream
 * @Description Stream表达式
 * @Author Administrator
 * @Date 2020/1/15 11:20
 * @Version 1.0
 */
public class Stream {
	static List<Article> articleList = new ArrayList<>();
	static {
		articleList.add(new Article(1, "路遥", "平凡的世界"));
		articleList.add(new Article(2, "余华", "活着"));
		articleList.add(new Article(3, "吴承恩", "西游记"));
		articleList.add(new Article(3, "吴承恩", "西游记"));
		articleList.add(new Article(4, "施耐庵", "水浒传"));
		articleList.add(new Article(5, "罗贯中", "三国演义"));
		articleList.add(new Article(6, "曹雪芹", "红楼梦"));
		articleList.add(new Article(7, "简·奥斯汀", "傲慢与偏见"));
	}

	public static void main(String[] args) {
//		articleList.stream()
//			.filter((x) -> x.getId() > 1)
//			.limit(10)
//			.distinct()
//			.skip(4)
//			.sorted((x, y) -> Integer.compare(x.getId(), y.getId()))
//			.forEach((x) -> System.out.println(x));

		Optional<Integer> reduce = articleList.stream().map((x) -> x.getId()).reduce(Integer::sum);
		System.out.println(reduce.get());
	}
}
