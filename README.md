                    performance-annotation-logging-boot-starter

starter project for performance logging using annotation as default pointut expression (including stopwatch code).
This library uses a Advisor to combine the pointcut expression from properties file and performance log advices together.

Usage

step 1: Add the following dependency to your your Spring Boot Application POM:

       <dependency>
			<artifactId>performance-annotation-logging-boot-starter</artifactId>
			<groupId>com.custom.performance.annotation</groupId>
			<version>0-SNAPSHOT</version>
		</dependency>

step 2: update the application.properties 

point_cut = (execution(* com.some.service..*.*(..)) && @annotation(com.custom.performance.annotation.logging.PerformanceMonitored))

step 3: Include the method level annotation under performance

@PerformanceMonitored

 public methodName() {
 
 ********
 
 }