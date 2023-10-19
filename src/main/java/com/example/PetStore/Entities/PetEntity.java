package com.example.PetStore.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "pet_entity")
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "Integer")
    private Integer id;

    @Column(name = "name", columnDefinition = "VARCHAR(250)")
    private String name;

    @Column(name="definition", columnDefinition = "TEXT")
    private String definition;

    @Column(name = "price", columnDefinition = "decimal")
    private Double price;

    @Column(name = "weight", columnDefinition = "decimal")
    private Double weight;

    public PetEntity(String name, String definition, Double price, Double weight) {
        this.name = name;
        this.definition = definition;
        this.price = price;
        this.weight = weight;
    }

    public PetEntity() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
