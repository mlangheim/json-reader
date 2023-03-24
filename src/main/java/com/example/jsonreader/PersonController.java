package com.example.jsonreader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/persons")
    public String showAllPersons(Model model) {
        Iterable<Person> persons = personRepository.findAll();
        model.addAttribute("persons", persons);
        return "persons";
    }
}
