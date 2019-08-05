package messaging.rabbitmq.dto;

public class Car {
	
	private String label;

	public Car() {}
	
	public Car(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
