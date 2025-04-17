package com.recipe.recipeSocial.service;

import com.recipe.recipeSocial.dto.RecipeRequest;
import com.recipe.recipeSocial.model.Ingredient;
import com.recipe.recipeSocial.model.Recipe;
import com.recipe.recipeSocial.repository.RecipeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }


    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @Transactional
    public void createRecipe(RecipeRequest recipeRequest) {
        Recipe recipe = new Recipe();
        recipe.setName(recipeRequest.getName());
        recipe.setDescription(recipeRequest.getDescription());
        recipe.setInstructions(recipeRequest.getInstructions());

        List<Ingredient> ingredients = recipeRequest.getIngredients().stream()
                .map(dto -> {
                    Ingredient ingredient = new Ingredient();
                    ingredient.setName(dto.getName());
                    ingredient.setAmount(dto.getAmount());
                    ingredient.setUnit(dto.getUnit());
                    ingredient.setRecipe(recipe);
                    return ingredient;
                })
                .collect(Collectors.toList());

        recipe.setIngredients(ingredients);
        recipeRepository.save(recipe);
    }
}
