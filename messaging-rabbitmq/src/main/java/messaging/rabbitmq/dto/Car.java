package messaging.rabbitmq.dto;

public class Car {
	
	private String mark;
	private Motor motor;
	
	public Car() {}

	public Car(String mark, Motor motor) {
		this.mark = mark;
		this.motor = motor;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public Motor getMotor() {
		return motor;
	}

	public void setMotor(Motor motor) {
		this.motor = motor;
	}

}
