package hu.unideb.inf.webproject_backend.data.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Characters", uniqueConstraints = {@UniqueConstraint(columnNames = {"series", "name"})})
public class CharacterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
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

    public CharacterEntity(String series, String name, String species, String gender, int age, double height, double weight) {
        this.series = series;
        this.name = name;
        this.species = species;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public CharacterEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
