package ph.com.ola.webservice.main.exception;

import org.apache.logging.log4j.util.Strings;

public class FoodNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -3445289003913190075L;

	public FoodNotFoundException(Long foodId) {
		super("Could not find food with ID "  + Strings.quote(String.valueOf(foodId)));
	}
}
