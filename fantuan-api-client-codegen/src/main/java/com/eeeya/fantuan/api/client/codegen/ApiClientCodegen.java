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
        argumentList.add("-l");
        argumentList.add("com.eeeya.fantuan.api.client.codegen.MyJavaClientCodegen");
//        argumentList.add("-l");
//        argumentList.add("java");
        argumentList.add("-i");
        argumentList.add("http://127.0.0.1:8080/api-docs");
        Codegen.main(argumentList.toArray(myArgs));
    }
}
