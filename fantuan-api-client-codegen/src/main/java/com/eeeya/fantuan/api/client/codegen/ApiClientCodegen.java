package com.eeeya.fantuan.api.client.codegen;

import com.wordnik.swagger.codegen.Codegen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhonghui
 * @since 5/11/15.
 */
public class ApiClientCodegen {
    public static void main(String[] args){
        String[] myArgs = args.clone();
        List<String> argumentList = new ArrayList<String>();
        argumentList.addAll(Arrays.asList(args));
//        argumentList.add("-l");
//        argumentList.add("java");
        argumentList.add("-i");
        argumentList.add("http://test.daidaiduoduo.com:80/api-docs");
        argumentList.add("-l");

        List<String> javaArgumentList = new ArrayList<String>(argumentList);
        javaArgumentList.add("com.eeeya.fantuan.api.client.codegen.MyJavaClientCodegen");
        Codegen.main(javaArgumentList.toArray(myArgs));

        List<String> androidArgumentList = new ArrayList<String>(argumentList);
        androidArgumentList.add("com.eeeya.fantuan.api.client.codegen.MyAndroidClientCodegen");
        Codegen.main(androidArgumentList.toArray(myArgs));
    }
}
