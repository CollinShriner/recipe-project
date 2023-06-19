package shriner.springpractice.recipeproject.repositories;

import org.springframework.data.repository.CrudRepository;
import shriner.springpractice.recipeproject.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
