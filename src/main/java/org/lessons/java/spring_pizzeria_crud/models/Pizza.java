package org.lessons.java.spring_pizzeria_crud.models;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Bisogna inserire un nome per la pizza")
    @Size(max = 100, message = "Nome troppo lungo")
    private String name;

    @NotBlank(message = "Bisogna inserire gli ingredienti della pizza")
    private String description;
    private String urlImmagine;

    @Min(value = 1, message = "Il corsto della pizza deve essere maggiore di 0")
    private BigDecimal price;

    public Pizza() {
    }

    public Pizza(String name, String description, String urlImmagine, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.urlImmagine = urlImmagine;
        this.price = price;
    }

    // GETTERS
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUrlImmagine() {
        return urlImmagine;
    }

    public BigDecimal getPrice() {
        return price;
    }

    // SETTERS
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUrlImmagine(String urlImmagine) {
        this.urlImmagine = urlImmagine;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
