package com.custom.performance.annotation.logging;

import java.util.concurrent.TimeUnit;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Stopwatch;

public class AroundLogPerformanceAdvice implements MethodInterceptor {
	private static final String METHOD_NAME = "method-name";
	private static final String EXECUTION_TIME = "execution-time";

	public Object invoke(MethodInvocation invocation) throws Throwable {
		logBegin(invocation);

		// Invoke the target method
		Stopwatch s = Stopwatch.createStarted();
		Object result = invocation.proceed();

		logEnd(invocation, s);
		return result;
	}

	 private static void logBegin(MethodInvocation invocation) {
	          Logger logger = LoggerFactory.getLogger(invocation.getMethod().getDeclaringClass());
	          logger.info("METHOD_NAME " + invocation.getMethod().getName(), "calling");
	      }

	      private static void logEnd(MethodInvocation invocation, Stopwatch s) {
	          Logger logger = LoggerFactory.getLogger(invocation.getMethod().getDeclaringClass());
	          logger.info("METHOD_NAME " + invocation.getMethod().getName() + " EXECUTION_TIME " + s.elapsed(TimeUnit.MILLISECONDS), "completed");
	      }

}
