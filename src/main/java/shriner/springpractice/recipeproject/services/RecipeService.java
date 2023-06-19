package shriner.springpractice.recipeproject.services;

import org.springframework.stereotype.Service;
import shriner.springpractice.recipeproject.domain.Recipe;

import java.util.List;

public interface RecipeService {

    List<Recipe> listAllRecipes();
}
