package shriner.springpractice.recipeproject.services.implemented;

import org.springframework.stereotype.Service;
import shriner.springpractice.recipeproject.domain.Recipe;
import shriner.springpractice.recipeproject.repositories.RecipeRepository;
import shriner.springpractice.recipeproject.services.RecipeService;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Recipe> listAllRecipes() {
        Iterable<Recipe> iterableRecipes = recipeRepository.findAll();
        List<Recipe> recipeList = new ArrayList<>();
        iterableRecipes.forEach(recipeList::add);
        return recipeList;
    }
}
