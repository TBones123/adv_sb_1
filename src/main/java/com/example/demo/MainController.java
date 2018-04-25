package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class MainController {
    private ArrayList<Person> people =
            new ArrayList<Person>(){{
                this.add(new Person(1, "vasya"));
                this.add(new Person(2, "petya"));
                this.add(new Person(3, "kolya"));
                this.add(new Person(4, "polya"));

            }};
    @GetMapping("/")
    public String one(){
        return "index";
    }
    @GetMapping("/greeting")
    public String two(Model model,
                      @RequestParam("imya") String name){
        model.addAttribute("here", name);
        return "kokos";
    }
    @PostMapping("/greeting")
    public String three(Model model, @RequestParam  int id){
        Person person1 = people.stream().filter(person -> person.
                getId() == id).findFirst().get();
        model.addAttribute("user", person1);
        return"kokos";
    }
}
