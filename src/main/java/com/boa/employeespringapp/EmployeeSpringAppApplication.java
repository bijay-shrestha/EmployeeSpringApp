package com.boa.employeespringapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class EmployeeSpringAppApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeSpringAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
