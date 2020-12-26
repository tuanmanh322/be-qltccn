package com.datn.qltccn.config;

import com.datn.qltccn.security.jwt.JWTConfigurer;
import com.datn.qltccn.security.jwt.TokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	private final CorsFilter corsFilter;

	private final TokenProvider tokenProvider;

	public WebSecurityConfig(CorsFilter corsFilter, TokenProvider tokenProvider) {
		this.corsFilter = corsFilter;
		this.tokenProvider = tokenProvider;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
				.csrf()
				.disable()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.authorizeRequests()
//                .antMatchers("/api/authenticate").permitAll()
//                .antMatchers("/api/user/register").permitAll()
				.antMatchers("/api/upload").authenticated()
				.antMatchers("/api/user/profile").authenticated()
				.antMatchers("/api/user/update-profile").authenticated()
				.antMatchers("/api/**").permitAll()
  				.antMatchers("/greeting").permitAll()
//                .antMatchers("/api/location/find-top-job-city/{topCity}").permitAll()
//                .antMatchers(HttpMethod.GET, "/api/location").permitAll()
//                .antMatchers("/api/location/**").hasAnyRole(UserTypeEnum.ADMIN.getName())
//                .antMatchers("/**").authenticated()
				.and()
				.httpBasic()
				.and()
				.apply(securityConfigurerAdapter())
				.and()
				.addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)
				.exceptionHandling()
				.accessDeniedPage("/403");
	}

	private JWTConfigurer securityConfigurerAdapter() {
		return new JWTConfigurer(tokenProvider);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**","/uploads/**,/**");
	}
}
