package shriner.springpractice.recipeproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import shriner.springpractice.recipeproject.domain.Category;
import shriner.springpractice.recipeproject.domain.UnitOfMeasure;
import shriner.springpractice.recipeproject.repositories.CategoryRepository;
import shriner.springpractice.recipeproject.repositories.UnitOfMeasureRepository;
import shriner.springpractice.recipeproject.services.RecipeService;

import java.util.Optional;

@Controller
public class indexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    private RecipeService recipeService;

    public indexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, RecipeService recipeService) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeService=recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndex(Model model){
        model.addAttribute("recipes", recipeService.listAllRecipes());

        return "index";
    }
}
