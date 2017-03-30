package inheritance;

public class CargoCar extends TrainCar {
	
	private int cargoWeight;

	public CargoCar(int deadWeight, int cargoWeight) {
		super(deadWeight);
		this.cargoWeight = cargoWeight;
		this.totalWeight = deadWeight + this.cargoWeight;
	}
	
	public int getCargoWeight() {
		return cargoWeight;
	}
	
	public void setCargoWeight(int cargoWeight) {
		this.cargoWeight = cargoWeight;
		this.totalWeight = this.cargoWeight + this.deadWeight;
	}
	
	@Override
	public String toString() {
		return "CargoCar";
	}

}
