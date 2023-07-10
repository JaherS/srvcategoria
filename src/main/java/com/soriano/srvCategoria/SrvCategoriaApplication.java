package com.soriano.srvCategoria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@EnableSwagger2
@EntityScan({"com.soriano.model"})
@SpringBootApplication
public class SrvCategoriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SrvCategoriaApplication.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				//.apis(RequestHandlerSelectors.any())
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.paths(PathSelectors.any())
				.build().apiInfo(getApiInfo());
	}
	private ApiInfo getApiInfo() {
		return new ApiInfo("Categoria API", "Gestiona las categorias en demo", "1.0.0", "termsOfServiceUrl",
				new Contact("Solo", "https://www.XXXXX.com.co", "soporte@xxx.com.co"), "licencia",
				"url de licencia", Collections.emptyList());
	}
}
