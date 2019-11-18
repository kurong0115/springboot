package com.star.springboot.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @ClassName RedisAspect
 * @Description Redis缓存配置类
 * @Author Administrator
 * @Date 2019/11/14 14:58
 * @Version 1.0
 */
@Aspect
@Component
public class RedisAspect {

	@Pointcut("@annotation(com.star.springboot.annotation.RedisCache)")
	public void pointCut(){

	}

	@Around("pointCut()")
	public Object enableCache(ProceedingJoinPoint proceedingJoinPoint){
		StringBuilder sb = new StringBuilder();
		Object[] args = proceedingJoinPoint.getArgs();
		Object obj = args[0];
		Class<?> clazz = obj.getClass();
		try {
			Method method = clazz.getDeclaredMethod("getId", null);
			Object invoke = method.invoke(obj, null);
			System.err.println(invoke.toString());
			obj = proceedingJoinPoint.proceed(args);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
		return obj;
	}
}
