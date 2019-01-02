package ph.com.ola.webservice.main.model;

import javax.validation.constraints.NotBlank;

public class FoodDto {
	
	private Long foodId;
	
	@NotBlank(message = "food name is required")
	private String name;
	
	@NotBlank(message = "description is required")
	private String description;
	
	@NotBlank(message = "type is required")
	private String type;
	
	public FoodDto() {
		super();
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

	public Long getFoodId() {
		return foodId;
	}

	public void setFoodId(Long foodId) {
		this.foodId = foodId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
}
