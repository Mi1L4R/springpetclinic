package com.udemy.springpetclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.udemy.springpetclinic"})
public class SpringpetclinicApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringpetclinicApplication.class, args);
    }

}
