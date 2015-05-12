package com.eeeya.fantuan.api.client.codegen;

import com.wordnik.swagger.codegen.ClientOptInput;
import com.wordnik.swagger.codegen.ClientOpts;
import com.wordnik.swagger.codegen.Codegen;
import com.wordnik.swagger.models.Operation;
import com.wordnik.swagger.models.Path;
import com.wordnik.swagger.models.Swagger;
import io.swagger.parser.SwaggerParser;
import org.apache.commons.cli.*;

import java.io.File;
import java.util.*;

/**
 * @author zhonghui
 * @since 5/11/15.
 */
public class MyCodegen extends Codegen {
    public static void main(String[] args){
        String[] myArgs = args.clone();
        List<String> argumentList = new ArrayList<String>();
        argumentList.addAll(Arrays.asList(args));
        argumentList.add("-l");

        List<String> languageArgumentList = new ArrayList<String>(argumentList);
        languageArgumentList.add("com.eeeya.fantuan.api.client.codegen.MySwaggerGenerator");
        languageArgumentList.add("-i");
        languageArgumentList.add("http://127.0.0.1:8080/api-docs");
        codegen(languageArgumentList.toArray(myArgs));

        languageArgumentList = new ArrayList<String>(argumentList);
        languageArgumentList.add("com.eeeya.fantuan.api.client.codegen.MyJavaClientCodegen");
        languageArgumentList.add("-i");
        languageArgumentList.add(CodegenConfig.SWAGGER_API_DOCS_DIR + File.separator + "swagger.json");
        codegen(languageArgumentList.toArray(myArgs));

        languageArgumentList = new ArrayList<String>(argumentList);
        languageArgumentList.add("com.eeeya.fantuan.api.client.codegen.MyAndroidClientCodegen");
        languageArgumentList.add("-i");
        languageArgumentList.add(CodegenConfig.SWAGGER_API_DOCS_DIR + File.separator + "swagger.json");
        codegen(languageArgumentList.toArray(myArgs));
    }

    @Override
    public List<File> generate(){
        for(Path path : swagger.getPaths().values()){
            for(Operation operation : path.getOperations()){
                List<String> newTags = new ArrayList<String>();
                for(String tag: operation.getTags()){
                    if(tag != null){
                        newTags.add(getOperationTag(tag));
                    }
                }
                operation.setTags(newTags);
            }
        }
        return super.generate();
    }

    public String getOperationTag(String operationPath) {
        if(operationPath == null){
            return null;
        }
        String newOperationPath = operationPath.replaceFirst("^apiv[0-9\\.]*", "");
        newOperationPath = newOperationPath.replaceAll("\\{.*?\\}", "");
        return newOperationPath;
    }


    static Map<String, com.wordnik.swagger.codegen.CodegenConfig> configs = new HashMap<String, com.wordnik.swagger.codegen.CodegenConfig>();
    static String configString;
    static {
        List<com.wordnik.swagger.codegen.CodegenConfig> extensions = getExtensions();
        StringBuilder sb = new StringBuilder();

        for(com.wordnik.swagger.codegen.CodegenConfig config : extensions) {
            if(sb.toString().length() != 0)
                sb.append(", ");
            sb.append(config.getName());
            configs.put(config.getName(), config);
            configString = sb.toString();
        }
    }

    static String debugInfoOptions = "\nThe following additional debug options are available for all codegen targets:" +
            "\n -DdebugSwagger prints the swagger specification as interpreted by the codegen" +
            "\n -DdebugModels prints models passed to the template engine" +
            "\n -DdebugOperations prints operations passed to the template engine" +
            "\n -DdebugSupportingFiles prints additional data passed to the template engine";
    public static void codegen(String[] args) {

        StringBuilder sb = new StringBuilder();

        Options options = new Options();
        options.addOption("h", "help", false, "shows this message");
        options.addOption("l", "lang", true, "client language to generate.\nAvailable languages include:\n\t[" + configString + "]");
        options.addOption("o", "output", true, "where to write the generated files");
        options.addOption("i", "input-spec", true, "location of the swagger spec, as URL or file");
        options.addOption("t", "template-dir", true, "folder containing the template files");
        options.addOption("d", "debug-info", false, "prints additional info for debugging");
        options.addOption("a", "auth", false, "addes authorization headers when fetching the swagger definitions remotely. Pass in a URL-encoded string of name:header with a comma separating multiple values");

        ClientOptInput clientOptInput = new ClientOptInput();
        ClientOpts clientOpts = new ClientOpts();
        Swagger swagger = null;

        CommandLine cmd = null;
        try {
            CommandLineParser parser = new BasicParser();
            com.wordnik.swagger.codegen.CodegenConfig config = null;

            cmd = parser.parse(options, args);
            if (cmd.hasOption("d")) {
                usage(options);
                System.out.println(debugInfoOptions);
                return;
            }
            if (cmd.hasOption("a"))
                clientOptInput.setAuth(cmd.getOptionValue("a"));
            if (cmd.hasOption("l"))
                clientOptInput.setConfig(getConfig(cmd.getOptionValue("l")));
            else {
                usage(options);
                return;
            }
            if (cmd.hasOption("o"))
                clientOptInput.getConfig().setOutputDir(cmd.getOptionValue("o"));
            if (cmd.hasOption("h")) {
                if(cmd.hasOption("l")) {
                    config = getConfig(String.valueOf(cmd.getOptionValue("l")));
                    if(config != null) {
                        options.addOption("h", "help", true, config.getHelp());
                        usage(options);
                        return;
                    }
                }
                usage(options);
                return;
            }
            if (cmd.hasOption("i"))
                swagger = new SwaggerParser().read(cmd.getOptionValue("i"), clientOptInput.getAuthorizationValues(), true);
            if (cmd.hasOption("t"))
                clientOpts.getProperties().put("templateDir", String.valueOf(cmd.getOptionValue("t")));
        }
        catch (Exception e) {
            usage(options);
            return;
        }
        try{
            clientOptInput
                    .opts(clientOpts)
                    .swagger(swagger);
            new MyCodegen().opts(clientOptInput).generate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<com.wordnik.swagger.codegen.CodegenConfig> getExtensions() {
        ServiceLoader<com.wordnik.swagger.codegen.CodegenConfig> loader = ServiceLoader.load(com.wordnik.swagger.codegen.CodegenConfig.class);
        List<com.wordnik.swagger.codegen.CodegenConfig> output = new ArrayList<com.wordnik.swagger.codegen.CodegenConfig>();
        Iterator<com.wordnik.swagger.codegen.CodegenConfig> itr = loader.iterator();
        while(itr.hasNext()) {
            output.add(itr.next());
        }
        return output;
    }

    static void usage(Options options) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp( "Codegen", options );
    }

    public static com.wordnik.swagger.codegen.CodegenConfig getConfig(String name) {
        if(configs.containsKey(name)) {
            return configs.get(name);
        }
        else {
            // see if it's a class
            try {
                System.out.println("loading class " + name);
                Class customClass = Class.forName(name);
                System.out.println("loaded");
                return (com.wordnik.swagger.codegen.CodegenConfig)customClass.newInstance();
            }
            catch (Exception e) {
                throw new RuntimeException("can't load class " + name);
            }
        }
    }


}
