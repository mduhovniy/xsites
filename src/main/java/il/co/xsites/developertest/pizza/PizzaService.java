package il.co.xsites.developertest.pizza;

import il.co.xsites.developertest.base.ro.ResultRO;

public interface PizzaService {

	ResultRO getMenu(String name, Double minPrice, Double maxPrice);

	ResultRO orderPizza(Long id);
}
