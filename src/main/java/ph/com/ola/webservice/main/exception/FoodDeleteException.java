package ph.com.ola.webservice.main.exception;

public class FoodDeleteException extends RuntimeException {

	private static final long serialVersionUID = -7371382924252848216L;

	public FoodDeleteException(Long foodId) {
		super("Delete food with ID " + foodId + " has failed! ");
	}
}
