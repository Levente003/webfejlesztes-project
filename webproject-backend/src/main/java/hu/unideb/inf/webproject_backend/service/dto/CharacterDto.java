package hu.unideb.inf.webproject_backend.service.dto;

import java.util.Objects;

public class CharacterDto {
    private long id;
    private String name;
    private String series;
    private String species;
    private String gender;
    private int age;
    private double height;
    private double weight;

    public CharacterDto() {
    }

    public CharacterDto(String name, String series, String species, String gender, int age, double height, double weight) {
        this.name = name;
        this.series = series;
        this.species = species;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public CharacterDto(long id, String name, String series, String species, String gender, int age, double height, double weight) {
        this.id = id;
        this.name = name;
        this.series = series;
        this.species = species;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CharacterDto that = (CharacterDto) o;
        return age == that.age && Double.compare(height, that.height) == 0 && Double.compare(weight, that.weight) == 0 && Objects.equals(name, that.name) && Objects.equals(series, that.series) && Objects.equals(species, that.species) && Objects.equals(gender, that.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, series, species, gender, age, height, weight);
    }

}
