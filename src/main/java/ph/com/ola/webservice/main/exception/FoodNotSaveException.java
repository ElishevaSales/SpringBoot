package ph.com.ola.webservice.main.exception;

public class FoodNotSaveException extends RuntimeException {

	private static final long serialVersionUID = -9135128233566238776L;

	public FoodNotSaveException(String foodName) {
		super("Saving food failed! " + foodName);
	}
}
