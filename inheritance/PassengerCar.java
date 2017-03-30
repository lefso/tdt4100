package inheritance;

public class PassengerCar extends TrainCar {

	private int passengerCount;
	
	public PassengerCar(int deadWeight, int passengerCount) {
		super(deadWeight);
		this.passengerCount = passengerCount;
		this.totalWeight = deadWeight + this.passengerCount * 80;
	}
	
	public int getPassengerCount() {
		return passengerCount;
	}
	
	public void setPassengerCount(int passengerCount) {
		this.passengerCount = passengerCount;
		this.totalWeight = deadWeight + this.passengerCount * 80;
	}

	@Override
	public String toString() {
		return "PassengerCar";
	}
}
