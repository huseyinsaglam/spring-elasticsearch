package com.example.springelasticsearch.api;

import com.example.springelasticsearch.entity.Person;
import com.example.springelasticsearch.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PersonApi {

    private final PersonRepository personRepository;

    @PostMapping("/add")
    private ResponseEntity<Person> add(@RequestBody Person person) {
        return ResponseEntity.ok(personRepository.save(person));
    }

    @GetMapping("/{search}")
    private ResponseEntity<List<Person>> getPerson(@PathVariable String search) {
        List<Person> persons = personRepository.getByCustomQuery(search);
        return ResponseEntity.ok(persons);
    }

    @GetMapping("/surname/{surname}")
    private ResponseEntity<List<Person>> getPersonList(@PathVariable String surname) {
        List<Person> persons = personRepository.findBySurname(surname);
        return ResponseEntity.ok(persons);
    }


}
