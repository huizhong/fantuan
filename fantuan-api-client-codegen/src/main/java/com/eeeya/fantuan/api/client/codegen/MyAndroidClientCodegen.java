package com.eeeya.fantuan.api.client.codegen;

import com.wordnik.swagger.codegen.SupportingFile;
import com.wordnik.swagger.codegen.languages.AndroidClientCodegen;

import java.io.File;

/**
 * @author zhonghui
 * @since 5/11/15.
 */
public class MyAndroidClientCodegen extends AndroidClientCodegen {
    public MyAndroidClientCodegen(){
        super();

        invokerPackage = CodegenConfig.ANDROID_INVOKER_PACKAGE;
        groupId = CodegenConfig.ANDROID_GROUP_ID;
        artifactId = CodegenConfig.ANDROID_ARTIFACT_ID;
        artifactVersion = CodegenConfig.ANDROID_ARTIFACT_VERSION;

        apiPackage = CodegenConfig.ANDROID_API_PACKAGE;
        modelPackage = CodegenConfig.ANDROID_MODEL_PACKAGE;

        outputFolder = "fantuan-api-android-client";

        additionalProperties.clear();
        additionalProperties.put("invokerPackage", invokerPackage);
        additionalProperties.put("groupId", groupId);
        additionalProperties.put("artifactId", artifactId);
        additionalProperties.put("artifactVersion", artifactVersion);

        supportingFiles.clear();

        supportingFiles.add(new SupportingFile("pom.mustache", "", "pom.xml"));
        supportingFiles.add(new SupportingFile("apiInvoker.mustache",
                (sourceFolder + File.separator + invokerPackage).replace(".", java.io.File.separator), "ApiInvoker.java"));
        supportingFiles.add(new SupportingFile("httpPatch.mustache",
                (sourceFolder + File.separator + invokerPackage).replace(".", java.io.File.separator), "HttpPatch.java"));
        supportingFiles.add(new SupportingFile("jsonUtil.mustache",
                (sourceFolder + File.separator + invokerPackage).replace(".", java.io.File.separator), "JsonUtil.java"));
        supportingFiles.add(new SupportingFile("apiException.mustache",
                (sourceFolder + File.separator + invokerPackage).replace(".", java.io.File.separator), "ApiException.java"));
    }

    @Override
    public String toApiFilename(String name) {
        return initialCaps(name) + "Api";
    }

}
