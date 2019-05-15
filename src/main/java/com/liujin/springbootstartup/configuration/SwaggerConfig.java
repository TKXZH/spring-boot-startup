package com.liujin.springbootstartup.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zonghuixu
 */
@EnableSwagger2
@Configuration
@Import(SpringDataRestConfiguration.class)
public class SwaggerConfig {

	//是否开启swagger，正式环境一般是需要关闭的，可根据springboot的多环境配置进行设置
	Boolean swaggerEnabled = true;

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
			// 是否开启
			.enable(swaggerEnabled).select()
			// 扫描的路径包
			.apis(RequestHandlerSelectors.basePackage("com.liujin.springbootstartup"))
			// 指定路径处理PathSelectors.any()代表所有的路径
			.paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
			.title("Product Service")
			.description("used to build as a micro service")
			// 作者信息
			.version("1.0.0")
			.build();
	}
}
