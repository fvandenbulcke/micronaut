package messaging.rabbitmq.dto;

public class Motor {
	
	private String energy;
	private Integer powor;
	
	public Motor() {}
	
	public Motor(String energy, Integer powor) {
		this.energy = energy;
		this.powor = powor;
	}

	public String getEnergy() {
		return energy;
	}

	public void setEnergy(String energy) {
		this.energy = energy;
	}
	
	public Integer getPowor() {
		return powor;
	}
	
	public void setPowor(Integer powor) {
		this.powor = powor;
	}
	
}
