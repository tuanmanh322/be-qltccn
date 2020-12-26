package com.datn.qltccn.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
@EnableWebMvc
public class CrosFilter implements WebMvcConfigurer {
	private static final Logger log = LoggerFactory.getLogger(CrosFilter.class);
	private static final String ALL = "*";
	@Value("${application.cors.allowed-origins}")
	private String allowedOrigins;

	@Value("${application.cors.allowed-methods}")
	private String allowedMethods;

	@Value("${application.cors.allowed-headers}")
	private String allowedHeaders;

	@Value("${application.cors.exposed-headers}")
	private String exposedHeaders;


	@Value("${application.cors.max-age}")
	private long maxAge;


	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		this.setAllowedOrigins(config);
		this.setAllowedHeaders(config);
		this.setAllowedMethods(config);
		this.setExposedHeaders(config);
//		config.setAllowCredentials(true);
		config.setMaxAge(maxAge);
		if (config.getAllowedOrigins() != null && !config.getAllowedOrigins().isEmpty()) {
			log.debug("Registering CORS filter");
			source.registerCorsConfiguration("/api/**", config);
		}
		return new CorsFilter(source);
	}

	private void setAllowedOrigins(CorsConfiguration config){
		if(ALL.equals(allowedOrigins)) {
			config.addAllowedOrigin(ALL);
		} else {
			config.setAllowedOrigins(Arrays.asList(allowedOrigins.split(",")));
		}
	}
	private void setAllowedMethods(CorsConfiguration config){
		if(ALL.equals(allowedMethods)) {
			config.addAllowedMethod(ALL);
		} else {
			config.setAllowedMethods(Arrays.asList(allowedMethods.split(",")));
		}
	}
	private void setAllowedHeaders(CorsConfiguration config){
		if(ALL.equals(allowedOrigins)) {
			config.addAllowedHeader(ALL);
		} else {
			config.setAllowedHeaders(Arrays.asList(allowedHeaders.split(",")));
		}
	}
	private void setExposedHeaders(CorsConfiguration config){
		if(ALL.equals(exposedHeaders)) {
			config.addExposedHeader(ALL);
		} else {
			config.setExposedHeaders(Arrays.asList(exposedHeaders.split(",")));
		}
	}
}
