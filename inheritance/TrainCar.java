package inheritance;

public class TrainCar {
	
	protected int totalWeight;
	protected int deadWeight;
	
	public TrainCar(int deadWeight) {
		this.deadWeight = deadWeight;
		this.totalWeight = deadWeight;
	}
	
	public int getTotalWeight() {
		return totalWeight;
	}
	
	public void setDeadWeight(int deadWeight) {
		this.deadWeight = deadWeight;
		
		if (this instanceof PassengerCar) {
			totalWeight = this.deadWeight + ((PassengerCar) this).getPassengerCount() * 80;
		} else if (this instanceof CargoCar) {
			totalWeight = this.deadWeight + ((CargoCar) this).getCargoWeight();
		}
	}
	
	public int getDeadWeight() {
		return deadWeight;
	}
	
}
