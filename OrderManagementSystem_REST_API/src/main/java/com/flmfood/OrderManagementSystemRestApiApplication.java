package com.flmfood;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;

import com.github.benmanes.caffeine.cache.Caffeine;

import io.micrometer.core.aop.CountedAspect;
import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;

@SpringBootApplication
@EnableCaching
public class OrderManagementSystemRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderManagementSystemRestApiApplication.class, args);
	}
	

	// for metrics to calc time and count of API response
	@Bean
	public TimedAspect timeAspect(MeterRegistry meterRegistry) {
		return new TimedAspect(meterRegistry);
		
	}
	
	// for metrics to calc time and count of API response
	@Bean
	public CountedAspect countAspect(MeterRegistry meterRegistry) {
		return new CountedAspect(meterRegistry);
		
	}
	
	
	@Bean
	public CacheManager cacheManager() {
		
		CaffeineCacheManager cacheManager = new CaffeineCacheManager("items");
	cacheManager.setCaffeine(
			
			  Caffeine.newBuilder()
			  .maximumSize(100)
			  .expireAfterWrite(2,TimeUnit.MINUTES)
			
			);
	
	
	return cacheManager;
	}
	
	
	
	
	
	

}



