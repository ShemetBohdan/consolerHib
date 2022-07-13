package com.example.consolerhib.service;

import com.example.consolerhib.model.Animals;
import com.example.consolerhib.model.Persone;
import com.example.consolerhib.repository.AnimalsRepository;
import com.example.consolerhib.repository.PersoneRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AnimalsService {

    private final AnimalsRepository animalsRepository;

    private final PersoneRepository personeRepository;

    private final SessionFactory sessionFactory;

    public AnimalsService(AnimalsRepository animalsRepository, PersoneRepository personeRepository,
                          SessionFactory sessionFactory) {
        this.animalsRepository = animalsRepository;
        this.personeRepository = personeRepository;
        this.sessionFactory = sessionFactory;
    }
    public Animals getAnimals(Integer id) {
        return this.animalsRepository.findById(id).get();
    }

    public Animals saveAnimals(Animals animals) {
        return this.animalsRepository.save(animals);
    }

    public void removeAnimals(int id) {
        this.animalsRepository.deleteById(id);
    }

    @Transactional
    public void removeAnimalsWhithPersone(Integer id) {
        Integer personeId = this.animalsRepository.findById(id).get().getPersone().getPersoneId();
        this.animalsRepository.deleteById(id);
        this.personeRepository.deleteById(personeId);

    }

    public Persone getPersoneByAnimalsId(Integer id){
        Session currentSession = this.sessionFactory.openSession();
        Animals animals = currentSession.find(Animals.class,id);
        return animals.getPersone();
    }
}
