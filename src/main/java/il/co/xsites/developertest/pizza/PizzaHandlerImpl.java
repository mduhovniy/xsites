package il.co.xsites.developertest.pizza;

import il.co.xsites.developertest.pizza.model.PizzaMenu;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component(value = "pizzaHandler")
public class PizzaHandlerImpl implements PizzaHandler {

	protected Log log = LogFactory.getLog(getClass());

	@Autowired
	private PizzaDao pizzaDao;


	@Override
	@Transactional(readOnly = true)
	public List<PizzaMenu> getPizzaMenu() {
		return pizzaDao.getPizzaMenus();
	}

	@Override
	@Transactional(readOnly = true)
	public List<PizzaMenu> getPizzaMenuByPriceBetween(Double minPrice, Double maxPrice) {
		return pizzaDao.getPizzaMenusByPriceBetween(minPrice, maxPrice);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PizzaMenu> getPizzaMenuByNameAndPriceBetween(String name, Double minPrice, Double maxPrice) {
		return pizzaDao.getPizzaMenusByNameAndPriceBetween(name, minPrice, maxPrice);
	}

	@Override
	@Transactional(readOnly = true)
	public PizzaMenu getPizza(Long id) {
		return pizzaDao.getPizza(id);
	}
}
