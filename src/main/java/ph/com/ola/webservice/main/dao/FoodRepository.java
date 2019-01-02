package ph.com.ola.webservice.main.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ph.com.ola.webservice.main.model.Food;

@Repository
public interface FoodRepository extends CrudRepository<Food, Long> {

	List<Food> findByType(String type);
}
