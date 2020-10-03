package il.co.xsites.developertest.pizza;

import il.co.xsites.developertest.pizza.model.PizzaMenu;

import java.util.List;

public interface PizzaDao {

	List<PizzaMenu> getPizzaMenus();

	PizzaMenu getPizza(Long id);
}
