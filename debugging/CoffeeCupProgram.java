package debugging;

import java.util.Random;

public class CoffeeCupProgram {

	private CoffeeCup cup;
	private Random r;
	
	public void init(){
		cup = new CoffeeCup();
		r = new Random(123456789L);
	}
	
	public void run(){
//		part1();
		part2();
	}
	
	private void part1(){
		cup.increaseCupSize(40.0);
		cup.fillCoffee(20.5);
		cup.drinkCoffee(Math.floor(r.nextDouble()*20.5));
		cup.fillCoffee(32.5);
		cup.drinkCoffee(Math.ceil(r.nextDouble()*38.9));
		cup.drinkCoffee(Math.ceil(r.nextDouble()*42));
		cup.increaseCupSize(17);
		cup.drinkCoffee(40);
		cup.drinkCoffee(Math.ceil(r.nextDouble()*42));
		cup.drinkCoffee(Math.floor(r.nextDouble()*20.5));
		cup.fillCoffee(32.5);
		cup.drinkCoffee(Math.ceil(r.nextDouble()*38.9));
		cup.drinkCoffee(Math.ceil(r.nextDouble()*42));
		cup.increaseCupSize(17);
	}
	
	private void part2(){
		cup = new CoffeeCup(40.0, 20.5);
		r = new Random(987654321L);
		cup.drinkCoffee(Math.floor(r.nextDouble()*20.5));
		cup.fillCoffee(Math.floor(r.nextDouble()*30));
		cup.drinkCoffee(Math.ceil(r.nextDouble()*38.9));
		cup.drinkCoffee(Math.ceil(r.nextDouble()*42));
		cup.increaseCupSize(Math.floor(r.nextDouble()*26));
		//cup.fillCoffee(Math.ceil(r.nextDouble()*59)); //prøver å fylle for mye kaffe. kapasitet er 40. Prøver å fylle 40 men har 6.5 fra før.
		//cup.drinkCoffee(Math.ceil(r.nextDouble()*42)); //prøver å drikke for mye kaffe. har 6.5 prøver å drikke 29.0
		cup.increaseCupSize(Math.floor(r.nextDouble()*35));
		cup.fillCoffee(Math.floor(r.nextDouble()*30));
		cup.increaseCupSize(Math.floor(r.nextDouble()*26)); //ender opp på 65.0 capacity og 6.5 cunnertVolume.
	}
	
	
	public static void main(String[] args) {
		CoffeeCupProgram program = new CoffeeCupProgram();
		program.init();
		program.run();
	}

}
