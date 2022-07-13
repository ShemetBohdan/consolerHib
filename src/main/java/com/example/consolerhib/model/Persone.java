package com.example.consolerhib.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persone {

    @Id
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "persone_id")
    private Integer personeId;
    private String name;
    private String surname;
    private int age;
    private String gender;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "persone_id")
    @JsonIgnore
    private List<Animals> animals;
}
