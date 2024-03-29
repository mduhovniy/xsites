package il.co.xsites.developertest.pizza;

import il.co.xsites.developertest.annotations.ExtractableForQuery;
import il.co.xsites.developertest.base.ro.ResultRO;
import il.co.xsites.developertest.pizza.model.PizzaMenu;
import il.co.xsites.developertest.pizza.ro.PizzaMenuRO;
import il.co.xsites.developertest.utils.Utils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("pizzaService")
public class PizzaServiceImpl implements PizzaService {

	protected Log log = LogFactory.getLog(getClass());

	@Autowired
	private PizzaHandler pizzaHandler;

	@Override
	public ResultRO getMenu(String name, Double minPrice, Double maxPrice) {

		ResultRO resultRO = new ResultRO();
		if(name == null & minPrice == null && maxPrice == null) {
			return getMenu();
		}
		minPrice = minPrice == null ? 0 : minPrice;
		maxPrice = maxPrice == null ? Double.MAX_VALUE : maxPrice;

		try {
			Utils.validatePizzaPrices(minPrice, maxPrice);

			List<PizzaMenu> menu;
			if(name == null) {
				menu = pizzaHandler.getPizzaMenuByPriceBetween(minPrice, maxPrice);
			} else {
				menu = pizzaHandler.getPizzaMenuByNameAndPriceBetween(name, minPrice, maxPrice);
			}
			List<PizzaMenuRO> menuRO = new ArrayList<>();

			for(PizzaMenu pizzaMenu : menu) {
				menuRO.add(pizzaMenu.getRepresentation());
			}

			resultRO.setResult(menuRO);
		} catch(Exception e) {
			resultRO.setSuccess(false);
			resultRO.setError(e.getMessage());
		}

		return resultRO;
	}

	@Override
	public ResultRO orderPizza(Long id) {
		ResultRO resultRO = new ResultRO();

		PizzaMenu pizzaMenu = pizzaHandler.getPizza(id);
		String pizzaQueryString = Utils.extractQueryString(pizzaMenu, ExtractableForQuery.class);

		resultRO.setResult(pizzaQueryString);

		return resultRO;
	}

	private ResultRO getMenu() {
		ResultRO resultRO = new ResultRO();

		try {
			List<PizzaMenu> menu = pizzaHandler.getPizzaMenu();
			List<PizzaMenuRO> menuRO = new ArrayList<>();

			for(PizzaMenu pizzaMenu : menu) {
				menuRO.add(pizzaMenu.getRepresentation());
			}

			resultRO.setResult(menuRO);
		} catch(Exception e) {
			resultRO.setSuccess(false);
			resultRO.setError(e.getMessage());
		}

		return resultRO;
	}
}
