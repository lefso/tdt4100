package inheritance;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Train {

	Collection<TrainCar> trainCars = new ArrayList<>();
	
	public void addTrainCar(TrainCar trainCar) {
		trainCars.add(trainCar);
	}
	
	public boolean contains(TrainCar trainCar) {
		return trainCars.contains(trainCar);
	}
	
	public int getTotalWeight() {
		Iterator<TrainCar> iterator = trainCars.iterator();
		int totalWeight = 0;
		
		while (iterator.hasNext()) {
			TrainCar trainCar = iterator.next();
			totalWeight += trainCar.getTotalWeight();
		}
		
		return totalWeight;
	}
	
	public int getPassengerCount() {
		Iterator<TrainCar> iterator = trainCars.iterator();
		int totalPassengers = 0;
		
		while (iterator.hasNext()) {
			TrainCar trainCar = iterator.next();
			
			if (trainCar instanceof PassengerCar) {
				totalPassengers += ((PassengerCar) trainCar).getPassengerCount();
			}
		}
		return totalPassengers;
	}
	
	public int getCargoWeight() {
		Iterator<TrainCar> iterator = trainCars.iterator();
		int cargoWeight = 0;
		
		while (iterator.hasNext()) {
			TrainCar trainCar = iterator.next();
			
			if (trainCar instanceof CargoCar) {
				cargoWeight += ((CargoCar) trainCar).getCargoWeight();
			}
		}
		return cargoWeight;
	}
	
	@Override
	public String toString() {
		String finalStr = "";
		Iterator<TrainCar> iterator = trainCars.iterator();
		
		while (iterator.hasNext()) {
			TrainCar trainCar = iterator.next();
			finalStr += trainCar.toString() + ": \n";
			
			finalStr += "Total weight: " + trainCar.getTotalWeight() + "\n";
			
			if (trainCar instanceof PassengerCar) {
				finalStr += "Passengers: " + ((PassengerCar) trainCar).getPassengerCount() + "\n";
			} else if (trainCar instanceof CargoCar) {
				finalStr += "Cargo weight: " + ((CargoCar) trainCar).getCargoWeight() + "\n";
			}
			finalStr += "\n";
		}
		
		return finalStr;
	}
	
	public static void main(String[] args) {
		PassengerCar pc = new PassengerCar(2000, 200);
		PassengerCar pc2 = new PassengerCar(1500, 100);
		CargoCar cc = new CargoCar(3000, 5000);
		CargoCar cc2 = new CargoCar(2500, 7000);
		Train train = new Train();
		
		train.addTrainCar(pc);
		train.addTrainCar(pc2);
		train.addTrainCar(cc);
		train.addTrainCar(cc2);
		
		System.out.println(train);
		
	}
}











