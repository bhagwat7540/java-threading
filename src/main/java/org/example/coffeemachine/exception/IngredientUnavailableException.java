package org.example.coffeemachine.exception;

public class IngredientUnavailableException extends RuntimeException{
    public IngredientUnavailableException() {
        super("Ingredient not available");
    }
}
