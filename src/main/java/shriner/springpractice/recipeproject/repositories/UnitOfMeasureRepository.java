package shriner.springpractice.recipeproject.repositories;

import org.springframework.data.repository.CrudRepository;
import shriner.springpractice.recipeproject.domain.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
}
