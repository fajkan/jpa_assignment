package se.lexicon.jpa_assignment.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import se.lexicon.jpa_assignment.entities.Recipe;
import se.lexicon.jpa_assignment.entities.RecipeCategory;
import se.lexicon.jpa_assignment.entities.RecipeIngredient;

import java.util.Collection;

public interface RecipeRepository extends CrudRepository<Recipe,Integer> {


    @Query("select a from Recipe a where a.recipeName = :recipeName")
    Collection<Recipe> findRecipeByRecipeName (@Param("recipeName") String recipeName);

    @Query("select a from Recipe a where a.recipeCategories = :recipeCategories")
    Collection<Recipe> FindRecipeByRecipeCategories(@Param("recipeCategory") String recipeCategories);
    
    @Query("select a from RecipeIngredient a where a.ingredient = :ingredient")
    Collection<RecipeIngredient> searchAllRecipeByIngredientQuery(@Param("ingredient") String ingredient);

    @Query("select a from RecipeCategory a where a.category = :categoryName")
    Collection<RecipeCategory> searchAllRecipeByCategoryQuery(@Param("categoryName") String categoryName);

}
