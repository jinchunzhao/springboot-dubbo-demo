package com.jy.order.config;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * 注解开启 swagger2 功能
 * 
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-07-31 10:41
 */
@EnableSwagger2
@Configuration
//@EnableSwaggerBootstrapUI
//@Profile({"prod","test"}) //只在dev test环境中有效
//@PropertySources({ @PropertySource(value = "classpath:swagger2.properties", ignoreResourceNotFound = true, encoding = "UTF-8") })
public class SwaggerConfig implements WebMvcConfigurer {

	private String pathMapping;

	/**
	  * @Description: TODO 创建 Docket Bean
	  * @author jcz
	  * @date 2020/1/5 + 22:07
	  * @param
	  * @return springfox.documentation.spring.web.plugins.Docket
	  */
	@Bean
	public Docket docket(){
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.jy.order.controller"))
				.paths(PathSelectors.any())
				.build();
//		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
//				.apis(SwaggerConfig.basePackage("com.jy.modules.manage.controller,com.jy.modules.user.controller")).paths(PathSelectors.any()).build();

	}
	/**
	  * @Description: TODO 创建API的基本信息
	  * @author jcz
	  * @date 2020/1/5 + 22:25
	  * @param
	  * @return springfox.documentation.service.ApiInfo
	  */
	public ApiInfo apiInfo(){
		return new ApiInfoBuilder()
				.title("利用swagger2构建的API文档")
				//.description("用restful风格写接口")
				.termsOfServiceUrl("https://springfox.github.io/springfox/docs/current/")
				.version("1.0")
				.build();
	}


	private static Optional<? extends Class<?>> declaringClass(RequestHandler input) {
		return Optional.fromNullable(input.declaringClass());
	}


	/**
	  * Predicate that matches RequestHandler with given base package name for the class of the handler method.
	  * This predicate includes all request handlers matching the provided basePackage
	  * @author jcz
	  * @date 2020/1/5 + 23:14
	  * @param basePackage  base package of the classes
	  * @return com.google.common.base.Predicate<springfox.documentation.RequestHandler>
	  */
	public static Predicate<RequestHandler> basePackage(final String basePackage) {
		return new Predicate<RequestHandler>() {

			@Override
			public boolean apply(RequestHandler input) {
				return declaringClass(input).transform(handlerPackage(basePackage)).or(true);
			}
		};
	}

	/**
	  * @Description: TODO 处理包路径配置规则,支持多路径扫描匹配以逗号隔开
	  * @author jcz
	  * @date 2020/1/5 + 23:03
	  * @param basePackage  --扫描包路径
	  * @return com.google.common.base.Function<java.lang.Class<?>,java.lang.Boolean>
	  */
	private static Function<Class<?>, Boolean> handlerPackage(final String basePackage) {
		return new Function<Class<?>, Boolean>() {

			@Override
			public Boolean apply(Class<?> input) {
				for (String strPackage : basePackage.split(",")) {
					boolean isMatch = input.getPackage().getName().startsWith(strPackage);
					if (isMatch) {
						return true;
					}
				}
				return false;
			}
		};
	}


}
