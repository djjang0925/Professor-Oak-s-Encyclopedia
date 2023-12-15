package com.poke.oak.professoroak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.poke.oak"})
public class ProfessorOakApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProfessorOakApplication.class, args);
    }

}
