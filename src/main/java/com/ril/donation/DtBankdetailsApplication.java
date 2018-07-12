package com.ril.donation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
@EnableEurekaClient
@EnableCaching
@SpringBootApplication
public class DtBankdetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DtBankdetailsApplication.class, args);
	}
	@Bean
	public CacheManager cacheManager()
	{
		ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager("users");
		return cacheManager;
	}
}
