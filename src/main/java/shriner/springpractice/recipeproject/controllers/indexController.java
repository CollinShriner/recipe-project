package shriner.springpractice.recipeproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import shriner.springpractice.recipeproject.domain.Category;
import shriner.springpractice.recipeproject.domain.UnitOfMeasure;
import shriner.springpractice.recipeproject.repositories.CategoryRepository;
import shriner.springpractice.recipeproject.repositories.UnitOfMeasureRepository;

import java.util.Optional;

@Controller
public class indexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public indexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndex(){
        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Category Id is: " + categoryOptional.get().getId());
        System.out.println("Unit of Measure Id is: " + unitOfMeasureOptional.get().getId());

        return "index";
    }
}
