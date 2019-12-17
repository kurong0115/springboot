package com.star.springboot.service;

/**
 * @ClassName ScheduleTask
 * @Description 定时任务
 * @Author Administrator
 * @Date 2019/11/27 8:48
 * @Version 1.0
 */
public interface ScheduleTask {

	/**
	 * 打印当前时间
	 */
	void print();

	/**
	 * 增加访问
	 */
	void visit();
}
