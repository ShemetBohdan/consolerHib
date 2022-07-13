package com.example.consolerhib.controller;

import com.example.consolerhib.model.Animals;
import com.example.consolerhib.model.Persone;
import com.example.consolerhib.service.PersoneService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persone")
public class PersoneController {

    private PersoneService personeService;

    public PersoneController(PersoneService personeService) {
        this.personeService = personeService;
    }

    @GetMapping( value = "/{id}")
    @Cacheable(value = "personeId")
    public Persone getPersone(@PathVariable Integer id) {return this.personeService.getPersone(id);
    }

    @GetMapping( value = "/{id}/animals")
    public List<Animals> getAnimalsByPersone(@PathVariable Integer id) {
        return this.personeService.getAllAnimalsByPersone(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deletePersone(@PathVariable Integer id) {
        this.personeService.deletePersone(id);
    }

    @PutMapping
    public Persone savePersone(@RequestBody Persone persone){
        return this.personeService.savePersone(persone);
    }

}
