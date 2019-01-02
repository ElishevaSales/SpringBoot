package ph.com.ola.webservice.main.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ph.com.ola.webservice.main.enums.ResponseEnum;
import ph.com.ola.webservice.main.model.FoodDto;
import ph.com.ola.webservice.main.service.FoodService;

@RestController
public class FoodController {
	
	private static final Logger logger = LoggerFactory.getLogger(FoodController.class);
	
	@Autowired
	private FoodService foodService;
	
	@RequestMapping(value = "foods/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public FoodDto fetchEmployeeById(@PathVariable("id") Long id) {
		
		logger.info("Fetching food entry : {}", LocalDate.now());
		return foodService.findById(id);
		
	}
	

	@RequestMapping(value = "foods", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Map<String, Object>> createNewFood(@RequestBody @Valid FoodDto foodDto) {

		Map<String, Object> map = new HashMap<>();
		
		FoodDto newFoodDto = foodService.create(foodDto);
		map.put(ResponseEnum.FOOD.getValue(), newFoodDto);
		map.put(ResponseEnum.MESSAGE.getValue(), "Food is successfully created");
		
		logger.info("Food is successfully created.. message{}", LocalDate.now());
		
		return new ResponseEntity<>(map, HttpStatus.CREATED);

	}
	
	
	@RequestMapping(value = "foods", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Map<String, Object>> updateFood(@RequestBody FoodDto foodDto) {
		
		Map<String, Object> map = new HashMap<>();
		FoodDto newFoodDto = foodService.updateFood(foodDto);
		map.put(ResponseEnum.FOOD.getValue(), newFoodDto);
		map.put(ResponseEnum.MESSAGE.getValue(), "Food is successfully updated");
		
		logger.info("Food is successfully updated.. message{}", LocalDate.now());
		
		return new ResponseEntity<>(map, HttpStatus.OK);
		
		
	}
	
	@RequestMapping(value = "foods/{id}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Map<String, Object>> deleteFood(@PathVariable("id") Long id) {
		
		Map<String, Object> map = new HashMap<>();
		foodService.deleteFood(id);
		map.put(ResponseEnum.MESSAGE.getValue(), "Food with ID " + id  + " is successfully deleted");
		
		logger.info("Food is successfully deleted.. message{}", LocalDate.now());
		
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	


}
