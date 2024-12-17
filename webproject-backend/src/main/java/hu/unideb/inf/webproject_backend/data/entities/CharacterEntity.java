package hu.unideb.inf.webproject_backend.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Characters")
@Getter
@Setter
@NoArgsConstructor
public class CharacterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String series;

    @Column
    private String name;

    @Column
    private String species;

    @Column
    private String gender;

    @Column
    private int age;

    @Column
    private double height;

    @Column
    private double weight;

    @Column
    private String other; //JSON

    public CharacterEntity(String series, String name, String species, String gender, int age, double height, double weight, String other) {
        this.series = series;
        this.name = name;
        this.species = species;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.other = other;
    }

}
