package se.lexicon.jpa_assignment.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 255)
    private String recipeName;

    @OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.ALL},mappedBy = "recipe",orphanRemoval = true)
    private Collection<RecipeIngredient> recipeIngredients;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(table = "recipe_instruction",name = "instruction_id",unique = true)
    private RecipeInstruction recipeInstruction;

    @ManyToMany()
    @JoinTable(name = "recipe", joinColumns = @JoinColumn(name = "recipe_name"))//, inverseJoinColumns = @JoinColumn(name = "recipe_category"))
    private Collection<RecipeCategory> recipeCategories;




    public Recipe() {
    }

    public Recipe(String recipeName, Collection<RecipeIngredient> recipeIngredients, RecipeInstruction recipeInstruction, Collection<RecipeCategory> recipeCategories) {
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.recipeInstruction = recipeInstruction;
        this.recipeCategories = recipeCategories;
    }

    public Recipe(int id, String recipeName, Collection<RecipeIngredient> recipeIngredients, RecipeInstruction recipeInstruction, Collection<RecipeCategory> recipeCategories) {
        this.id = id;
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.recipeInstruction = recipeInstruction;
        this.recipeCategories = recipeCategories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public Collection<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(Collection<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public RecipeInstruction getRecipeInstruction() {
        return recipeInstruction;
    }

    public void setRecipeInstruction(RecipeInstruction recipeInstruction) {
        this.recipeInstruction = recipeInstruction;
    }

    public Collection<RecipeCategory> getRecipeCategories() {
        return recipeCategories;
    }

    public void setRecipeCategories(Collection<RecipeCategory> recipeCategories) {
        this.recipeCategories = recipeCategories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return id == recipe.id && Objects.equals(recipeName, recipe.recipeName) && Objects.equals(recipeIngredients, recipe.recipeIngredients) && Objects.equals(recipeInstruction, recipe.recipeInstruction) && Objects.equals(recipeCategories, recipe.recipeCategories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, recipeName, recipeIngredients, recipeInstruction, recipeCategories);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", recipeName='" + recipeName + '\'' +
                ", recipeIngredients=" + recipeIngredients +
                ", recipeInstruction=" + recipeInstruction +
                ", recipeCategories=" + recipeCategories +
                '}';
    }
}
