package com.eeeya.fantuan.api.client.codegen;

import com.wordnik.swagger.codegen.languages.SwaggerGenerator;
import com.wordnik.swagger.models.Swagger;

/**
 * @author zhonghui
 * @since 5/11/15.
 */
public class MySwaggerGenerator extends SwaggerGenerator {
    public MySwaggerGenerator(){
        super();
        outputFolder = CodegenConfig.SWAGGER_API_DOCS_DIR;
    }

    @Override
    public void processSwagger(Swagger swagger) {
        swagger.setHost(CodegenConfig.DEFAULT_API_HOST);
        super.processSwagger(swagger);
    }
}
