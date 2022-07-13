package com.example.consolerhib.controller;

import com.example.consolerhib.model.Animals;
import com.example.consolerhib.model.Persone;
import com.example.consolerhib.service.AnimalsService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/animals")
public class AnimalsController {

    private AnimalsService animalsService;

    public AnimalsController(AnimalsService animalService) {
        this.animalsService = animalService;
    }

    @GetMapping(value = "/{id}")
    @Cacheable(value = "animalsId")
    public Animals getAnimals(@PathVariable Integer id) {
        return this.animalsService.getAnimals(id);
    }

    @GetMapping(value = "/{id}/animals")
    public Persone getPersoneByAnimalsId(Integer id) {
        return this.animalsService.getPersoneByAnimalsId(id);
    }

    @PutMapping
    public Animals saveAnimals(@RequestBody Animals animals) {
        return this.animalsService.saveAnimals(animals);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteAnimals(@PathVariable Integer id) {
        this.animalsService.removeAnimals(id);
    }

    @DeleteMapping(value = "/{id}/persone")
    public void deleteAnimalsWhithPersone(Integer id) {
        this.animalsService.removeAnimalsWhithPersone(id);
    }
}
