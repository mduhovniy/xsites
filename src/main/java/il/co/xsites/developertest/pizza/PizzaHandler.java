package il.co.xsites.developertest.pizza;

import il.co.xsites.developertest.pizza.model.PizzaMenu;

import java.util.List;

public interface PizzaHandler {

	List<PizzaMenu> getPizzaMenu();

	List<PizzaMenu> getPizzaMenuByPriceBetween(Double minPrice, Double maxPrice);

	List<PizzaMenu> getPizzaMenuByNameAndPriceBetween(String name, Double minPrice, Double maxPrice);

	PizzaMenu getPizza(Long id);
}
