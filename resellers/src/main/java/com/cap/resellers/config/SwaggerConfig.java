package com.cap.resellers.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.core.jackson.ModelResolver;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {
    private final ApplicationContext applicationContext;
    private static final String SWAGGER_DOCS_VERSION = "1.0";

    @Bean
    public OpenAPI openAPI(ServletContext servletContext) {
        String contextPath = servletContext.getContextPath();
        Server server = new Server().url(contextPath);
        return new OpenAPI().servers(List.of(server)).components(authSetting()).info(swaggerInfo());
    }

    private io.swagger.v3.oas.models.info.Info swaggerInfo() {
        License license = new License();
        license.setUrl("https://github.com/jnu-resellers/resellers-be.git");
        license.setName("resellers");

        return new Info()
                .version(SWAGGER_DOCS_VERSION)
                .title("\"resellers 서버 API문서\"")
                .description("resellers 서버의 API 문서 입니다.")
                .license(license);
    }

    private Components authSetting() {
        return new Components()
                .addSecuritySchemes(
                        "access-token",
                        new io.swagger.v3.oas.models.security.SecurityScheme()
                                .type(io.swagger.v3.oas.models.security.SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                                .in(SecurityScheme.In.HEADER)
                                .name("Authorization"));
    }

    @Bean
    public ModelResolver modelResolver(ObjectMapper objectMapper) {
        return new ModelResolver(objectMapper);
    }

}