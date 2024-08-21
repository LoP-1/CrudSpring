package com.quantify.drugstore.controller;

import com.quantify.drugstore.model.Person;
import com.quantify.drugstore.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/person")
public class PersonController {

    private static Logger logger = LoggerFactory.getLogger(PersonController.class);
    @Autowired
    private PersonService personService;

    @GetMapping
    public String listPersons(Model model){
        model.addAttribute("person",personService.listAll());
        return "person-list";
    }

    @GetMapping("/new")
    public String seeFormUsers(Model model){
        model.addAttribute("person",new Person());
        return "person-form";
    }

    @PostMapping
    public String savePerson(Person person){
        personService.savePerson(person);
        return "redirect:/person";
    }

    @GetMapping("edit/{id}")
    public String seeFormEdit(@PathVariable Long id,Model model){
        model.addAttribute("person",personService.findById(id));
        return "person-form";
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable Long id, Model model){
        personService.deleteID(id);
        return "redirect:/person";
    }

}
