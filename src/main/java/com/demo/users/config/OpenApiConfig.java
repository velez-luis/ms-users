package com.demo.users.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.utils.SpringDocUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** ApiConfig.java
 * <p>
 * Clase de configuración para OpenAPI (Swagger).
 * Configura la documentación de la API y personaliza la información mostrada.
 * </p>
 *
 * @author Luis Velez
 * @version 1.0
 * */
@Configuration
public class OpenApiConfig {

    static {
        SpringDocUtils.getConfig()
                .replaceWithClass(org.springframework.data.domain.Pageable.class,
                        org.springdoc.core.converters.models.Pageable.class);
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("ms-users - API Docs")
                        .version("1.0")
                        .description("Spring Boot 3.4.5 with SpringDoc 2.8.5"));
    }
}
