package com.swu.shake.util;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class TimeHandler implements MethodInterceptor {
	private Logger logger = Logger.getLogger(this.getClass().getName());

	public Object invoke(MethodInvocation invocation) throws Throwable {
		long procTime = System.currentTimeMillis();
		if (invocation.getArguments().length != 0)
			logger.log(Level.INFO, invocation.getArguments()[0] + "开始执行"
					+ invocation.getMethod() + "方法");
		try {
			Object result = invocation.proceed();
			return result;
		} finally {
			procTime = System.currentTimeMillis() - procTime;
			if (invocation.getArguments().length != 0)
				logger.log(Level.INFO, invocation.getArguments()[0] + "执行"
						+ invocation.getMethod() + "方法结束");
			logger.log(Level.INFO, invocation.getMethod().getName() + "方法共用了"
					+ procTime + "毫秒");
		}
	}

}
