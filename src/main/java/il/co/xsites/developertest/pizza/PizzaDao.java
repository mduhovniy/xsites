package il.co.xsites.developertest.pizza;

import il.co.xsites.developertest.pizza.model.PizzaMenu;

import java.util.List;

public interface PizzaDao {

	List<PizzaMenu> getPizzaMenus();

	List<PizzaMenu> getPizzaMenusByPriceBetween(Double minPrice, Double maxPrice);

	List<PizzaMenu> getPizzaMenusByNameAndPriceBetween(String name, Double minPrice, Double maxPrice);

	PizzaMenu getPizza(Long id);
}
