package com.markmulvenna.synalogik.javatestsynalogik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JavaTestSynalogikApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaTestSynalogikApplication.class, args);
    }

    @GetMapping("/word-counter")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
       return String.format("Hello %s!", name);
    }

}
