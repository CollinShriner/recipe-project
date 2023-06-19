package shriner.springpractice.recipeproject.repositories;

import org.springframework.data.repository.CrudRepository;
import shriner.springpractice.recipeproject.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
