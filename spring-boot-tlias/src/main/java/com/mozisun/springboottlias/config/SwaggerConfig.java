package com.mozisun.springboottlias.config;


import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author moZiA
 * @date 2025/5/23 11:14
 * @description
 */
@Configuration
public class SwaggerConfig {

  @Bean
  public OpenAPI swaggerOpenApi() {
    return new OpenAPI().info(new Info().title("Tlias")
                                        .description("描述平台多牛逼")
                                        .version("v1.0.0"))

                        .externalDocs(new ExternalDocumentation().description("设计文档")
                                                                 .url(
                                                                     "https://juejin.cn/user/254742430749736/posts"));
  }
}