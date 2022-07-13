package com.example.consolerhib.service;

import com.example.consolerhib.model.Animals;
import com.example.consolerhib.model.Persone;
import com.example.consolerhib.repository.PersoneRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersoneService {

    private final PersoneRepository personeRepository;

    private final SessionFactory sessionFactory;

    public PersoneService(PersoneRepository personeRepository,
                          SessionFactory sessionFactory) {
        this.personeRepository = personeRepository;
        this.sessionFactory = sessionFactory;
    }


    public Persone getPersone(Integer id) {
        return this.personeRepository.findById(id).get();
    }

    public void deletePersone(Integer id) {
        this.personeRepository.deleteById(id);
    }

    public Persone savePersone(Persone persone) {
        return this.personeRepository.save(persone);
    }

    public List<Animals> getAllAnimalsByPersone(Integer id){
        Session session = this.sessionFactory.openSession();
        Query<Animals> query = session.createQuery("from Animals A where A.persone.id = :id",Animals.class);
        query.setParameter("id",id);
        return query.list();
    }
}
