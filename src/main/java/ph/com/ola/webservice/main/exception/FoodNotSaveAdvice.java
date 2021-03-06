package ph.com.ola.webservice.main.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class FoodNotSaveAdvice {
	
	@ExceptionHandler(FoodNotSaveException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Map<String, String> foodNotSaveHandler(FoodNotSaveException ex){
		Map<String, String> map = new HashMap<>();
		map.put("message", ex.getMessage());
		return map;
	}

}
