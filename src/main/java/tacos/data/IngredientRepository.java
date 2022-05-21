package tacos.data;

import tacos.Ingredient;

public interface IngredientRepository {
	Iterable<Ingredient> findAll();

	Ingredient findById(String id);

	Ingredient save(Ingredient ingredient);

	void delete(Ingredient ingredient);

	void edit(Ingredient ingredient);
}
