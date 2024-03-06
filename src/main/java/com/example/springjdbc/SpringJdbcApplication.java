package com.example.springjdbc;

import com.example.springjdbc.model.Alien;
import com.example.springjdbc.repository.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);
        Alien a = context.getBean(Alien.class);
        a.setId(101);
        a.setName("Navin");
        a.setTech("Java");
        AlienRepo repo = context.getBean(AlienRepo.class);

        repo.save(a);
        List<Alien> aliens = repo.findAll();
        for (Alien alien : aliens) {
            System.out.println(alien);
        }
    }

}
