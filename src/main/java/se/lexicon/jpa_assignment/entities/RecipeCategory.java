package se.lexicon.jpa_assignment.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;


@Entity
public class RecipeCategory {
    @Id
    private int id;
    @Column(nullable = false,length = 255)
    private String category;

    @ManyToMany
    private Collection<Recipe> recipes;




    public RecipeCategory() {
    }

    public RecipeCategory(int id, String category, Collection<Recipe> recipes) {
        this.id = id;
        this.category = category;
        this.recipes = recipes;
    }

    public RecipeCategory(String category, Collection<Recipe> recipes) {
        this.category = category;
        this.recipes = recipes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Collection<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Collection<Recipe> recipes) {
        this.recipes = recipes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeCategory that = (RecipeCategory) o;
        return id == that.id && Objects.equals(category, that.category) && Objects.equals(recipes, that.recipes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, recipes);
    }

    @Override
    public String toString() {
        return "RecipeCategory{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", recipes=" + recipes +
                '}';
    }
}
