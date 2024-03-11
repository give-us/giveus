package com.giveus.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * API 문서 관련 springdoc 설정 정의.
 */
@OpenAPIDefinition(info = @Info(title = "Giveus API Document", description = "API Document", version = "v1.0", contact = @Contact(name = "yihoney", email = "109622@naver.com")), tags = {
})
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder().group("controller").pathsToMatch("/api/**").build();
    }

//  @Bean
//  public Docket api() {
//    return new Docket(DocumentationType.OAS_30).useDefaultResponseMessages(false)
//        .select()
////        .apis(RequestHandlerSelectors.any())
//        .apis(RequestHandlerSelectors.basePackage("com.ssafy.api.controller"))
//        .paths(PathSelectors.ant("/api/**"))
//        .build()
//        .securityContexts(newArrayList(securityContext()))
//        .securitySchemes(newArrayList(apiKey()))
//        ;
//  }

//  private ApiKey apiKey() {
//    return new ApiKey(SECURITY_SCHEMA_NAME, "Authorization", "header");
//  }

//  private SecurityContext securityContext() {
//    return SecurityContext.builder()
//        .securityReferences(defaultAuth())
//        .build();
//  }

    public static final String SECURITY_SCHEMA_NAME = "JWT";
    public static final String AUTHORIZATION_SCOPE_GLOBAL = "global";
    public static final String AUTHORIZATION_SCOPE_GLOBAL_DESC = "accessEverything";

//  private List<SecurityReference> defaultAuth() {
//    AuthorizationScope authorizationScope =
//        new AuthorizationScope(AUTHORIZATION_SCOPE_GLOBAL, AUTHORIZATION_SCOPE_GLOBAL_DESC);
//    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//    authorizationScopes[0] = authorizationScope;
//    return newArrayList(new SecurityReference(SECURITY_SCHEMA_NAME, authorizationScopes));
//  }

//  @Bean
//  UiConfiguration uiConfig() {
//    return UiConfigurationBuilder.builder()
//        .supportedSubmitMethods(newArrayList("get").toArray(new String[0])) // try it 기능 활성화 범위
//        .operationsSorter(METHOD)
//        .build();
//  }

}
