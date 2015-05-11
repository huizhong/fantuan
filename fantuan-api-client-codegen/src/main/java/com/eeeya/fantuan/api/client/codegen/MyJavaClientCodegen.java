package com.eeeya.fantuan.api.client.codegen;

import com.wordnik.swagger.codegen.SupportingFile;
import com.wordnik.swagger.codegen.languages.JavaClientCodegen;

import java.io.File;

public class MyJavaClientCodegen extends JavaClientCodegen {

  public MyJavaClientCodegen() {
    super();

    invokerPackage = CodegenConfig.JAVA_INVOKER_PACKAGE;
    groupId = CodegenConfig.JAVA_GROUP_ID;
    artifactId = CodegenConfig.JAVA_ARTIFACT_ID;
    artifactVersion = CodegenConfig.JAVA_ARTIFACT_VERSION;

    apiPackage = CodegenConfig.JAVA_API_PACKAGE;
    modelPackage = CodegenConfig.JAVA_MODEL_PACKAGE;

    outputFolder = "fantuan-api-java-client";

    additionalProperties.clear();
    additionalProperties.put("invokerPackage", invokerPackage);
    additionalProperties.put("groupId", groupId);
    additionalProperties.put("artifactId", artifactId);
    additionalProperties.put("artifactVersion", artifactVersion);

    supportingFiles.clear();

    supportingFiles.add(new SupportingFile("pom.mustache", "", "pom.xml"));
    supportingFiles.add(new SupportingFile("apiInvoker.mustache",
      (sourceFolder + File.separator + invokerPackage).replace(".", File.separator), "ApiInvoker.java"));
    supportingFiles.add(new SupportingFile("JsonUtil.mustache", 
      (sourceFolder + File.separator + invokerPackage).replace(".", File.separator), "JsonUtil.java"));
    supportingFiles.add(new SupportingFile("apiException.mustache", 
      (sourceFolder + File.separator + invokerPackage).replace(".", File.separator), "ApiException.java"));
  }

}
