package ph.com.ola.webservice.main.enums;



public enum ResponseEnum {

	MESSAGE("message"),
	FOOD("food");
	
	
	String value;
	
	ResponseEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
