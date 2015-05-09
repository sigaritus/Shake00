package com.swu.shake.util;

import java.lang.reflect.Method;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.aop.ThrowsAdvice;

public class ExceptionHandler implements ThrowsAdvice {
	private Logger logger = Logger.getLogger(this.getClass().getName());

	public void afterThrowing(Method method, Object[] args, Object target,
			Throwable Subclass) throws Throwable {
		if(args.length != 0){
			logger.log(Level.INFO, args[0] + "执行" + method.getName() + "时有异常抛出"
					+ Subclass);
		}
	}
}
