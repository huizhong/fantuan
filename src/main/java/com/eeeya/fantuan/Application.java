package com.eeeya.fantuan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author ben@eeeya.com
 * @since 4/16/15
 */
@SpringBootApplication
@ComponentScan("com.eeeya.fantuan")
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
