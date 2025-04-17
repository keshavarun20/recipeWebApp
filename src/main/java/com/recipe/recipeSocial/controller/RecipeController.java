package com.recipe.recipeSocial.controller;


import com.recipe.recipeSocial.dto.RecipeRequest;
import com.recipe.recipeSocial.model.Recipe;
import com.recipe.recipeSocial.service.RecipeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/")
    public List<Recipe> getAllRecipes(){
        return recipeService.getAllRecipes();
    }

    @PostMapping("/recipes")
    public void createRecipe(@RequestBody RecipeRequest recipeRequest){
        recipeService.createRecipe(recipeRequest);
    }
}
