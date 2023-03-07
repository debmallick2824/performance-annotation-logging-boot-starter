package com.example.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.custom.performance.annotation.logging.PerformanceMonitored;

@RestController
public class DemoRestController {

	@PerformanceMonitored
	@RequestMapping(value = "/foo")
	public String getFoo() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "foo";
	}

}
