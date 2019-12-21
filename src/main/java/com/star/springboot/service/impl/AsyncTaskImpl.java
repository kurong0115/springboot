package com.star.springboot.service.impl;

import com.star.springboot.service.AsyncTask;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @ClassName AsyncTaskImpl
 * @Description 异步任务
 * @Author Administrator
 * @Date 2019/11/23 16:41
 * @Version 1.0
 */
@Service
public class AsyncTaskImpl implements AsyncTask {

    @Async
    @Override
    public void postMessage() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("send an email");
    }
}
