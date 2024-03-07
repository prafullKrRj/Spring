package com.prafull.springbootmvc;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AppController {

    AppController () {
        System.out.println("AppController created");
    }
    private List<Alien> aliens = new ArrayList<>();
    @GetMapping("/sum")
    public ResponseEntity<String> sum(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        int sum = num1 + num2;
        return ResponseEntity.ok(String.valueOf(sum));
    }
    @GetMapping("/alien/getAliens")
    public List<Alien> getAliens() {
        return aliens;
    }
    @PostMapping("/alien/addAlien")
    public void addAlien(@RequestBody Alien alien) {
        aliens.add(alien);
        System.out.println(aliens);
    }
}
class Alien {

    private int id;
    private String name;

    public Alien() {
        super();
        System.out.println("Object created");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Alien [id=" + id + ", name=" + name + "]";
    }
}