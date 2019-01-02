package ph.com.ola.webservice.main.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Food implements Serializable{
	
	private static final long serialVersionUID = 5709566209351252658L;

	@Id
	@GeneratedValue
	@Column(name = "FOOD_ID")
	private Long foodId;
	
	@Column(name = "FOOD_NAME")
	private String name;
	
	@Column(name = "FOOD_TYPE")
	private String type;
	
	@Column(name = "FOOD_DESC")
	private String description;
	
	
	public Food() {
		super();
		
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
