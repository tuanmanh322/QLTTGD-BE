package com.da.config;

import java.util.Arrays;

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

@Configuration
@EnableWebMvc
public class CrosFilter implements WebMvcConfigurer {
	private static final Logger log = LoggerFactory.getLogger(CrosFilter.class);
	private static final String ALL = "*";

	@Value("${application.cors.allowed-headers}")
	private String allowHeader;

	@Value("${application.cors.allowed-origins}")
	private String allowOrigins;

	@Value("${application.cors.allowed-methods}")
	private String allowMethod;

	@Value("${application.cors.exposed-headers}")
	private String exposedHeaders;

	@Value("${application.cors.allow-credentials}")
	private Boolean allowCredentials;

	@Value("${application.cors.max-age}")
	private Long maxAge;

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration configuration = new CorsConfiguration();
		this.setAllowedMethods(configuration);
		this.setAllowHeader(configuration);
		this.setAllowOrgin(configuration);
		this.setExposedHeaders(configuration);
		configuration.setAllowCredentials(allowCredentials);
		configuration.setMaxAge(maxAge);
		if (configuration.getAllowedOrigins() != null && !configuration.getAllowedOrigins().isEmpty()) {
			log.debug("Registering CORS FILTER!");
			source.registerCorsConfiguration("/api/**", configuration);
		}
		return new CorsFilter(source);
	}

	private void setAllowOrgin(CorsConfiguration config) {
		if (ALL.equals(allowOrigins)) {
			config.addAllowedOrigin(ALL);
		} else {
			config.setAllowedOrigins(Arrays.asList(allowOrigins.split(",")));
		}
	}

	private void setAllowHeader(CorsConfiguration config) {
		if (ALL.equals(allowHeader)) {
			config.addAllowedHeader(ALL);
		} else {
			config.setAllowedHeaders(Arrays.asList(allowHeader.split(",")));
		}
	}

	private void setAllowedMethods(CorsConfiguration config) {
		if (ALL.equals(allowMethod)) {
			config.addAllowedMethod(ALL);
		} else {
			config.setAllowedMethods(Arrays.asList(allowMethod.split(",")));
		}
	}

	private void setExposedHeaders(CorsConfiguration config) {
		if (ALL.equals(exposedHeaders)) {
			config.addExposedHeader(ALL);
		} else {
			config.setExposedHeaders(Arrays.asList(exposedHeaders.split(",")));
		}
	}
}
