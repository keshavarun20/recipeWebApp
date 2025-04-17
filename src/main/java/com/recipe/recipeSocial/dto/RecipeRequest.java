package com.recipe.recipeSocial.dto;

import lombok.Data;
import java.util.List;

@Data
public class RecipeRequest {
    private String name;
    private String description;
    private List<IngredientDTO> ingredients;
    private String instructions;

    @Data
    public static class IngredientDTO {
        private String name;
        private String amount;
        private String unit;
    }
}
