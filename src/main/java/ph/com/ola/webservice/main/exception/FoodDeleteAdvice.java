package ph.com.ola.webservice.main.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ph.com.ola.webservice.main.enums.ResponseEnum;

@ControllerAdvice
public class FoodDeleteAdvice {
	
	@ExceptionHandler(FoodDeleteException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Map<String, String> foodDeleteExceptionHandler(FoodDeleteException ex){
		Map<String, String> map = new HashMap<>();
		map.put(ResponseEnum.MESSAGE.getValue(), ex.getMessage());
		return map;
		
	}

}
