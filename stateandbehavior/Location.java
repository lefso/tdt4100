package stateandbehavior;

public class Location {
	
	int X = 0;
	int Y = 0;

	public void up() {
		 Y -= 1;
	}
	
	public void down() {
		Y += 1;
	}
	
	public void left() {
		X -= 1;
	}
	
	public void right() {
		X += 1;
	}
	
	public int getX() {
		System.out.println(X);
		return X;
	}
	
	public int getY() {
		System.out.println(Y);
		return Y;
	}
		
	public static void main(String[] args) {
		Location dude = new Location();
		
		dude.right();
		dude.getX();
		dude.down();
		dude.getY();
		dude.left();
		dude.up();
		
	}
}
