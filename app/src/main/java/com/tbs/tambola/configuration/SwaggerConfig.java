package com.tbs.tambola.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
  private static final String API_VERSION = "1.0";
  private static final String TITLE = "TBS Tambola API";
  private static final String DESCRIPTION = "A simple Service to create and manage tambola rooms";

  private static final String NAME = "Anurag Gupta";
  private static final String URL = "https://github.com/anuragguptanbmc";
  private static final String EMAIL = "anuragguptanbmc@gmail.com";

  private static final String LICENSE = "The MIT License";
  private static final String LICENSE_URL =
      "https://raw.githubusercontent.com/anuragguptanbmc/tambola-ui/master/LICENSE";

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title(TITLE)
        .version(API_VERSION)
        .description(DESCRIPTION)
        .contact(new Contact(NAME, URL, EMAIL))
        .license(LICENSE)
        .licenseUrl(LICENSE_URL)
        .build();
  }

  @Bean
  public Docket createDocket() {
    return new Docket(DocumentationType.OAS_30)
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.tbs.tambola.controller"))
        .paths(PathSelectors.any())
        .build();
  }

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowCredentials(true).allowedOrigins("*").allowedMethods("*");
      }
    };
  }
}
