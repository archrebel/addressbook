package com.archetype.addressbook.controllers;

import com.archetype.addressbook.domain.Person;
import com.archetype.addressbook.repositories.PersonRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persons")
@Transactional
public class PersonController {
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @GetMapping
    public Iterable<Person> addressBook() {
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getContactByName(@PathVariable("id") Long id) {
        return personRepository.findById(id)
                .map(person -> ResponseEntity.ok().body(person))
                .orElse(ResponseEntity.notFound().build());
    }
}
