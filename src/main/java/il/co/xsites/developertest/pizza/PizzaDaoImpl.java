package il.co.xsites.developertest.pizza;

import il.co.xsites.developertest.base.BaseDaoImpl;
import il.co.xsites.developertest.pizza.model.PizzaMenu;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings("ALL")
@Repository
public class PizzaDaoImpl extends BaseDaoImpl implements PizzaDao {

	@Override
	public List<PizzaMenu> getPizzaMenus() {
		Criteria criteria = getCurrentSession().createCriteria(PizzaMenu.class);
		return criteria.list();
	}

	@Override
	public List<PizzaMenu> getPizzaMenusByPriceBetween(Double minPrice, Double maxPrice) {
		Criteria criteria = getCurrentSession().createCriteria(PizzaMenu.class);
		criteria.add(Restrictions.between("price", minPrice, maxPrice));
		return criteria.list();
	}

	@Override
	public List<PizzaMenu> getPizzaMenusByNameAndPriceBetween(String name, Double minPrice, Double maxPrice) {
		Criteria criteria = getCurrentSession().createCriteria(PizzaMenu.class);
		criteria.add(Restrictions.like("name", name, MatchMode.ANYWHERE).ignoreCase());
		criteria.add(Restrictions.between("price", minPrice, maxPrice));
		return criteria.list();
	}

	@Override
	public PizzaMenu getPizza(Long id) {
		return findObject(PizzaMenu.class, id);
	}
}
