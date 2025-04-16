package com.recipe.recipeSocial.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Ingredient {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String amount;

    private String unit;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;


}
