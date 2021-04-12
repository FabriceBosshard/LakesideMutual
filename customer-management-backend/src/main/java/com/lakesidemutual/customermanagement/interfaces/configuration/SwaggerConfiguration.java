package com.lakesidemutual.customermanagement.interfaces.configuration;

import java.util.Collections;
import java.util.function.Predicate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The SwaggerConfiguration class configures the HTTP resource API documentation
 * that is generated by Springfox.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	@Bean
	public Docket customerManagementApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.any())
				.paths(paths())
				.build().apiInfo(apiInfo());
	}

	private Predicate<String> paths() {
		return PathSelectors.regex("/error|/actuator.*").negate();
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("Customer Management API", "This API allows call center operators to interact with customers and to edit their user profiles.", "v1.0.0", null, new Contact("", "", ""), null, null, Collections.emptyList());
	}
}