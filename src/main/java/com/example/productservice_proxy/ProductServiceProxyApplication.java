package com.example.productservice_proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ProductServiceProxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceProxyApplication.class, args);

    }

}
