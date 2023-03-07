package com.custom.performance.annotation.logging;

import org.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
public class AopPerformanceLoggingConfiguration  {

    
	static final String DEFAULT_VALUE = "@annotation(com.custom.performance.annotation.logging.PerformanceMonitored)";

    @Value("${point_cut:" + DEFAULT_VALUE + "}") private String pointcutExp;
    
    	
    @Bean(name = "aspectPerformanceLogPointcutAdvisor")
    public AspectJExpressionPointcutAdvisor createAspectJPointcutTestAdvisor() {
      //  AspectJPointcutAdvisor aspectAdvisorObject = new AspectJPointcutAdvisor();
    	AspectJExpressionPointcutAdvisor aspectAdvisorObject = new AspectJExpressionPointcutAdvisor();
        aspectAdvisorObject.setExpression(pointcutExp);
        aspectAdvisorObject.setAdvice(new AroundLogPerformanceAdvice());
        return aspectAdvisorObject;
    }
    
    

}
