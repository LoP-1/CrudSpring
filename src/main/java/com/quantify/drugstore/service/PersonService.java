package com.quantify.drugstore.service;

import com.quantify.drugstore.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quantify.drugstore.repository.PersonRepository;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> listAll(){
        return personRepository.findAll();
    }

    public Person savePerson(Person person){
        return personRepository.save(person);
    }

    public Person findById(Long id){

        return personRepository.findById(id).orElse(null);
    }

    public void deleteID(Long id){

        personRepository.deleteById(id);
    }

}
