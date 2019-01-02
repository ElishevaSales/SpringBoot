package ph.com.ola.webservice.main.service;

import java.time.LocalDate;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ph.com.ola.webservice.main.dao.FoodRepository;
import ph.com.ola.webservice.main.exception.FoodDeleteException;
import ph.com.ola.webservice.main.exception.FoodNotFoundException;
import ph.com.ola.webservice.main.exception.FoodNotSaveException;
import ph.com.ola.webservice.main.model.Food;
import ph.com.ola.webservice.main.model.FoodDto;

@Service
public class FoodServiceImpl implements FoodService {
	
	private static final Logger logger = LoggerFactory.getLogger(FoodServiceImpl.class);
	
	@Autowired
	private FoodRepository foodDao;

	@Override
	public FoodDto create(FoodDto foodDto) {
		
		FoodDto newFoodDto = new FoodDto();
		Food food = new Food();
		food.setDescription(foodDto.getDescription());
		food.setName(foodDto.getName());
		food.setType(foodDto.getType());
		
		try {
			Food newFood = foodDao.save(food);
			newFoodDto.setFoodId(newFood.getFoodId());
		} catch (Exception ex) {
			logger.info("Error on saving food: message{}", ex);
			throw new FoodNotSaveException(foodDto.getName());
		}
		
		return newFoodDto;
		
	}

	@Override
	public FoodDto findById(Long foodId) {
		
		FoodDto foodDto = new FoodDto();
		Optional<Food> food = foodDao.findById(foodId);
		if (food.isPresent()) {
			foodDto = convertFood(food.get());
		} else {
			String message = "No food found with ID" + foodId;
			logger.info(message, LocalDate.now());
			throw new FoodNotFoundException(foodId);
		}
		
		return foodDto;
	}

	

	@Override
	public FoodDto updateFood(FoodDto foodDto) {
		
		Food food = new Food();
		FoodDto newFoodDto = new FoodDto();
		food.setDescription(foodDto.getDescription());
		food.setName(foodDto.getName());
		food.setType(foodDto.getType());
		food.setFoodId(foodDto.getFoodId());
		
		try {
			Food newFood = foodDao.save(food);
			newFoodDto = convertFood(newFood);
		} catch (Exception ex) {
			logger.info("Error on updating the food.. message {}", ex);
			throw new FoodNotSaveException(food.getName());
		}
		
		return newFoodDto;
	}

	
	
	private FoodDto convertFood(Food food) {
		
		FoodDto  foodDto = new FoodDto();
		foodDto.setFoodId(food.getFoodId());
		foodDto.setType(food.getType());
		foodDto.setName(food.getName());
		foodDto.setDescription(food.getDescription());
		
		return foodDto;
	}
	


	@Override
	public void deleteFood(Long id) {
		
		try {
			foodDao.deleteById(id);
		} catch (Exception ex) {
			logger.info("Delete of food with ID " + id + " has failed!", ex);
			throw new FoodDeleteException(id);
		}
		
	}
	
}
