package com.nizwantowski.nortwnd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"clients"})
public class BazyApplication {

    public static void main(String[] args) {
        SpringApplication.run(BazyApplication.class, args);
    }

}
