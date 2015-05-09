package com.eeeya.fantuan.server.config;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.paths.SwaggerPathProvider;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.ModelMap;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.ServletContext;

/**
 * @author zhonghui
 * @since 1/16/15.
 */
@Configuration
@EnableSwagger //Loads the spring beans required by the framework
public class MySwaggerConfig {

    private SpringSwaggerConfig springSwaggerConfig;

    /**
     * Required to autowire SpringSwaggerConfig
     */
    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
        this.springSwaggerConfig = springSwaggerConfig;
        springSwaggerConfig.defaultIgnorableParameterTypes().add(ModelMap.class);

    }

    /**
     * Every SwaggerSpringMvcPlugin bean is picked up by the swagger-mvc framework - allowing for multiple
     * swagger groups i.e. same code base multiple swagger resource listings.
     */
    @Bean
    public SwaggerSpringMvcPlugin customImplementation() {
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
                .includePatterns("/api/.*?")
                .apiInfo(defaultApiInfo())
                .apiVersion("0.3")
                .pathProvider(new MySwaggerPathProvider());
    }

    @Autowired
    private ServletContext servletContext;


    public class MySwaggerPathProvider extends SwaggerPathProvider {

        @Override
        protected String applicationPath() {
            return getAppRoot()
                    .build()
                    .toString();
        }

        @Override
        protected String getDocumentationPath() {
            return getAppRoot()
                    .build()
                    .toString();
        }

        private UriComponentsBuilder getAppRoot() {
            String contextPath = servletContext.getContextPath();
            if(contextPath == null || contextPath.isEmpty()){
                contextPath = "/";
            }
            return UriComponentsBuilder.fromPath(contextPath);
        }
    }



    private ApiInfo defaultApiInfo() {

        return new ApiInfo(
                "API for YueFan",
                "约团前后端接口。<br/>" +
                "时间都是timestamp<br/>" +
                        "未特别说明，都返回Json",
                "",
                "",
                "",
                ""
        );
    }

}
