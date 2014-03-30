package com.waffle.openpayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author Kevin
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class PayrollServer {

	public static void main(String[] args) {
		SpringApplication.run(PayrollServer.class, args);
	}
}
