package com.star.springboot;

import io.searchbox.client.JestClient;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

/**
 * @ClassName ElasticsearchTest
 * @Description TODO
 * @Author Administrator
 * @Date 2019/11/23 16:54
 * @Version 1.0
 */
@SpringBootTest
public class ElasticsearchTest {

    @Autowired
    JestClient jestClient;

    @Test
    public void searchTest(){
        String expression = "{\n" +
                "\t\"query\":{\n" +
                "\t\t\"match\":{\n" +
                "\t\t\t\"content\":\"平凡\"\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}";
        Search search = new Search.Builder(expression).addIndex("kurong").addType("article").build();
        try {
            SearchResult execute = jestClient.execute(search);
            System.out.println(execute.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
