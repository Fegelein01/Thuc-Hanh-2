package tacos.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import tacos.data.IngredientRepository;
import tacos.Ingredient;

@Slf4j
@Controller
@RequestMapping("/ingredient")
public class IngredientController {
	private final IngredientRepository ingredientRepo;

	@Autowired
	public IngredientController(IngredientRepository ingredientRepo) {
		this.ingredientRepo = ingredientRepo;
	}

	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("ingredient", new Ingredient(null, null, 0, null));
		return "addIngredient";
	}

	@GetMapping("/delete")
	public String showDeleteForm(Model model, @RequestParam String id) {
		model.addAttribute("ingredient", ingredientRepo.findById(id));
//		ingredientRepo.delete(ingredientRepo.findById(id));
		return "deleteIngredient";
	}

	@GetMapping("/edit")
	public String showEditForm(Model model, @RequestParam String id) {
		model.addAttribute("ingredient", ingredientRepo.findById(id));
//		ingredientRepo.delete(ingredientRepo.findById(id));
		return "edit";
	}

	@GetMapping("/delete/yes")
	public String deleteProduct(@RequestParam String id) {
		ingredientRepo.delete(ingredientRepo.findById(id));
		return "home";
	}

	@GetMapping("/delete/no")
	public String returnHome1(@RequestParam String id) {
		return "home";
	}


	@PostMapping("/add")
	public String addIngredient(Ingredient ingredient, Model model) {
		ingredientRepo.save(ingredient);
		model.addAttribute(ingredient);
		log.info("Ingredient saved: " + ingredient);
		return "addIngredientSuccess";
	}
	
	
	@PostMapping("/edit")
	public String editIngredient(Ingredient ingredient, Model model) {
		ingredientRepo.edit(ingredient);
		return "home";
	}
}