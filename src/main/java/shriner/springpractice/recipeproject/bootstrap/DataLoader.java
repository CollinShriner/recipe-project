package shriner.springpractice.recipeproject.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import shriner.springpractice.recipeproject.domain.*;
import shriner.springpractice.recipeproject.repositories.CategoryRepository;
import shriner.springpractice.recipeproject.repositories.IngredientRepository;
import shriner.springpractice.recipeproject.repositories.RecipeRepository;
import shriner.springpractice.recipeproject.repositories.UnitOfMeasureRepository;

import java.math.BigDecimal;

@Component
public class DataLoader implements CommandLineRunner {

    private final RecipeRepository recipeRepository;
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final IngredientRepository ingredientRepository;

    public DataLoader(RecipeRepository recipeRepository, CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, IngredientRepository ingredientRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        UnitOfMeasure item = unitOfMeasureRepository.findByDescription("Item").get();
        UnitOfMeasure tableSpoon = unitOfMeasureRepository.findByDescription("Tablespoon").get();


        Ingredient avocado = new Ingredient();
        avocado.setAmount(new BigDecimal(2));
        avocado.setDescription("Avocado");
        avocado.setUom(item);

        Ingredient lime = new Ingredient();
        lime.setAmount(new BigDecimal(1));
        lime.setUom(tableSpoon);
        lime.setDescription("Lime");

        Recipe perfectGuac = new Recipe();
        perfectGuac.setDescription("Perfect Guacamole");
        perfectGuac.setDirections(
                "Cut the avocados:\n" +
                "\n" +
                "Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
                "How to make guacamole - scoring avocado\n" +
                "Elise Bauer\n" +
                "Mash the avocado flesh:\n" +
                "\n" +
                "Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
                "How to make guacamole - smashing avocado with fork\n" +
                "Elise Bauer\n" +
                "Add the remaining ingredients to taste:\n" +
                "\n" +
                "Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chilis. Chili peppers vary individually in their spiciness. So, start with a half of one chili pepper and add more to the guacamole to your desired degree of heat.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "Serve immediately:\n" +
                "\n" +
                "If making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.)\n" +
                "\n" +
                "Garnish with slices of red radish or jigama strips. Serve with your choice of store-bought tortilla chips or make your own homemade tortilla chips.");

        perfectGuac.setCookTime(0);
        perfectGuac.setPrepTime(10);
        perfectGuac.setDifficulty(Difficulty.MODERATE);
        perfectGuac.getCategories().add(categoryRepository.findByDescription("Mexican").get());
        perfectGuac.setServings(4);

        Notes guacNotes = new Notes();
        guacNotes.setRecipeNotes("HERE ARE THE GUAC NOTES");
        guacNotes.setRecipe(perfectGuac);
        perfectGuac.setNotes(guacNotes);




        perfectGuac.addIngredient(lime);
        perfectGuac.addIngredient(avocado);
        recipeRepository.save(perfectGuac);

        Recipe chickenTaco = new Recipe();
        Notes tacoNotes = new Notes();
        tacoNotes.setRecipeNotes("HERE ARE THE TACO NOTES");
        tacoNotes.setRecipe(chickenTaco);
        chickenTaco.setNotes(tacoNotes);
        chickenTaco.setDescription("Chicken Taco");
        chickenTaco.setDirections(
                        "Prepare the grill:\n" +
                        "\n" +
                        "Prepare either a gas or charcoal grill for medium-high, direct heat.\n" +
                        "Make the marinade and coat the chicken:\n" +
                        "\n" +
                        "In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                        "\n" +
                        "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                        "Spicy Grilled Chicken Tacos\n" +
                        "Sally Vargas\n" +
                        "Grill the chicken:\n" +
                        "\n" +
                        "Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165°F. Transfer to a plate and rest for 5 minutes.\n" +
                        "Thin the sour cream with milk:\n" +
                        "\n" +
                        "Stir together the sour cream and milk to thin out the sour cream to make it easy to drizzle.\n" +
                        "Assemble the tacos:\n" +
                        "\n" +
                        "Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.\n" +
                        "Warm the tortillas:\n" +
                        "\n" +
                        "Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                        "\n" +
                        "Wrap warmed tortillas in a tea towel to keep them warm until serving. ");

        chickenTaco.setCookTime(15);
        perfectGuac.setPrepTime(20);
        chickenTaco.setDifficulty(Difficulty.EASY);
        chickenTaco.getCategories().add(categoryRepository.findByDescription("Mexican").get());
        chickenTaco.setServings(6);

        UnitOfMeasure pound =unitOfMeasureRepository.findByDescription("Pound").get();
        UnitOfMeasure teaspoon = unitOfMeasureRepository.findByDescription("Teaspoon").get();

        Ingredient chicken = new Ingredient();

        chicken.setDescription("Chicken");
        chicken.setUom(pound);
        chicken.setAmount(new BigDecimal(6));

        Ingredient orangeJuice = new Ingredient();
        orangeJuice.setDescription("Orange Juice");
        orangeJuice.setUom(teaspoon);
        orangeJuice.setAmount(new BigDecimal(3));



        chickenTaco.addIngredient(orangeJuice);
        chickenTaco.addIngredient(chicken);


        recipeRepository.save(chickenTaco);

    }
}
