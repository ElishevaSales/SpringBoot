package ph.com.ola.webservice.main.service;

import ph.com.ola.webservice.main.model.FoodDto;

public interface FoodService {

	FoodDto create(FoodDto foodDto);
	
	FoodDto findById(Long id);
	
	FoodDto updateFood(FoodDto foodDto);
	
	void deleteFood(Long id);

}
