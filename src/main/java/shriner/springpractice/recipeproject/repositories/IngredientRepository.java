package shriner.springpractice.recipeproject.repositories;

import org.springframework.data.repository.CrudRepository;
import shriner.springpractice.recipeproject.domain.Category;
import shriner.springpractice.recipeproject.domain.Ingredient;

import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

}
