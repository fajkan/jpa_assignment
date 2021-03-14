package se.lexicon.jpa_assignment.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.jpa_assignment.entities.Ingredient;

import java.util.Collection;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {

    Collection<Ingredient> findIngredientByIngredient(String ingredient);

    Collection<Ingredient> findIngredientsByIngredientContains(String ingredient);
}
