package com.eeeya.fantuan;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

/**
 * @author ben@eeeya.com
 * @since 4/16/15
 */
@RestController
@EnableAutoConfiguration
public class FantuanStarter {
    @RequestMapping("/")
    String home() {
        return "Hello Fantuan!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(FantuanStarter.class, args);
    }
}
