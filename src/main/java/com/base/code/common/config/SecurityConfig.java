package com.base.code.common.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.beans.factory.annotation.Autowired;




@Configuration
@EnableResourceServer
@EnableWebSecurity
@Order(SecurityProperties.DEFAULT_FILTER_ORDER)
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableScheduling
@EnableCaching
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	public static final String JWT_TOKEN_HEADER_PARAM = "Authorization";
	public static final String IDP_TOKEN_HEADER_PARAM = "X-Authorization";
	public static final String[] PERMITTED_CONFIG_URIS = {
			"/api-docs/", "/api/docs/v2",
			"/swagger-resources/**",
			"swagger-ui.html",
			"/webjars/**",
			"beans", "beans.json",
			"liquibase", "liquibase.json",
			"/loggers/*",
			"/loggers", "loggers.json",
			"configprops", "configprops.json",
			"dump", "dump.json",
			"auditevents", "auditevents.json",
			"/metrics/*",
			"/metrics", "/metrics.json",
			"headdump", "headdump.json",
			"/autoconfig", "autoconfig.json",
			"mappings", "mappings.json",
			"info", "info.json",
			"/env/*",
			"/env", "/env.json",
			"/health", "/health.json",
			"/trace", "trace.json"
	};
	public static final String LOGIN_ENTRY_POINT = "/v1/login";
	public static final String TOKEN_BASED_AUTH_ENTRY_POINT = "/v1/**";
	public static final String TOKEN_REFRESH_ENTRY_POINT = "/v1/token";
	
	@Autowired
	private WebConfig webConfig;
	
	@Override
	@Order(Ordered.HIGHEST_PRECEDENCE)
	public void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable() // We don't need CSRF for JWT based authentication
		.authorizeRequests()
		.antMatchers(HttpMethod.OPTIONS,"/**").permitAll() // allow cors option calls
		.antMatchers(PERMITTED_CONFIG_URIS)
		.permitAll()
		.antMatchers(LOGIN_ENTRY_POINT).permitAll()
		.and().cors().configurationSource(webConfig.corsFilterSource());
	}

}
