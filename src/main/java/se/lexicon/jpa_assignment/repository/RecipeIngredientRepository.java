package se.lexicon.jpa_assignment.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.jpa_assignment.entities.RecipeIngredient;

public interface RecipeIngredientRepository extends CrudRepository<RecipeIngredient,Integer> {

}
