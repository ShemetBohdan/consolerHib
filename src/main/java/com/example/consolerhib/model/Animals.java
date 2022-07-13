package com.example.consolerhib.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animals {

    @Id
    @javax.persistence.Id
    @GeneratedValue
    @Column( name = "animals_id",updatable = false,nullable = false)
    private int animalsId;

    @ManyToOne()
    @JoinColumn(name = "persone_id",nullable = false )
    private Persone persone;

    private String kind;
    private String breed;
    private int age;


}
