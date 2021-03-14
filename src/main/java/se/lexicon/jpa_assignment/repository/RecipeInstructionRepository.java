package se.lexicon.jpa_assignment.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.jpa_assignment.entities.RecipeInstruction;

public interface RecipeInstructionRepository extends CrudRepository<RecipeInstruction,String> {
}
