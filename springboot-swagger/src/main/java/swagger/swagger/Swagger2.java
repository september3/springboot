package swagger.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger配置类---用于生成接口 文档
 * @author sunlele
 * @className Swagger2
 * @date 2019/5/23 12:10
 **/
@EnableSwagger2
@Configuration
public class Swagger2 {

    /**
     * 创建API应用
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("swagger.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 创建API基本信息
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("###")
                .termsOfServiceUrl("http://www.baidu.com")
                .version("1.0")
                .build();
    }

}
