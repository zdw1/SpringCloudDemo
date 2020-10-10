package com.init.springCloud;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	/**
	 *  Spring Security 默认开启了所有 CSRF 攻击防御，需要禁用 /eureka 的防御
	 * 新版本的security默认开启csrf了，关掉就好了
	 */
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable(); // 关闭csrf
		http.authorizeRequests().anyRequest().authenticated().and().httpBasic(); // 开启认证
	}
}
