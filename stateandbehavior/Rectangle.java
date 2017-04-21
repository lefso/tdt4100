package stateandbehavior;

public class Rectangle {

	private int minX = 0, minY = 0, maxX = 0, maxY = 0, width = 0, height = 0;

	public int getMinX() {
		return minX;
	}

	public void setMinX(int minX) {
		this.minX = minX;
		this.width = 1 + this.getMaxX() - this.minX;
	}

	public int getMinY() {
		return minY;
	}

	public void setMinY(int minY) {
		this.minY = minY;
		this.height = 1 + this.getMaxY() - this.minY;
	}

	public int getMaxX() {
		return maxX;
	}

	public void setMaxX(int maxX) {
		this.maxX = maxX;
		this.width = 1 + this.getMaxX() - this.getMinX();
	}

	public int getMaxY() {
		return maxY;
	}

	public void setMaxY(int maxY) {
		this.maxY = maxY;
		this.height = 1 + this.getMaxY() - this.getMinY();
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public boolean isEmpty() {
		if (this.height == 0 || this.width == 0) {
			return true;
		}
		return false;
	}
	
	public boolean contains(int x, int y) {
		if (this.isEmpty()) {
			return false;
		}
		if (this.maxX >= x && this.maxY >= y) {
			return true;
		}
		return false;
	}
	
	public boolean contains(Rectangle rect) {
		if (this.isEmpty()) {
			return false;
		} else if (this.getMinY() <= rect.getMinY() && this.getMinX() <= rect.getMinX() && this.getMaxY() >= this.getMaxY() && this.getMaxX() >= rect.getMaxX()) {
			return true;
		}
		return false;
	}
	
	public boolean add(int x, int y) {
		boolean result = false;
		
		if (this.isEmpty()) {
			this.setMaxX(x);
			this.setMinX(x);
			this.setMinY(y);
			this.setMaxY(y);
			result = true;
		}
		
		else if (!this.contains(x, y)) {
			if (x < this.getMinX()) {
				this.setMinX(x);
				result = true;
			} if (x > this.getMaxX()) {
				this.setMaxX(x);
				result = true;
			} if (y < this.getMinY()) {
				this.setMinY(y);
				result = true;
			} if (y > this.getMaxY()) {
				this.setMaxY(y);
				result = true;
			}
		}
		return result;
	}
	
	public boolean add(Rectangle rect) {
		boolean result = false;
		
		if (rect.isEmpty()) {
			result = false;
		}
		
		if (this.isEmpty()) {
			this.setMaxX(rect.getMaxX());
			this.setMinX(rect.getMinX());
			this.setMinY(rect.getMinY());
			this.setMaxY(rect.getMaxY());
			result = true;
		}
		
		if (this.getMinX() > rect.getMinX()) {
			this.setMinX(rect.getMinX());
			result = true;
		} if (this.getMinY() > rect.getMinY()) {
			this.setMinY(rect.getMinY());
			result = true;
		} if (this.getMaxX() < rect.getMaxX()) {
			this.setMaxX(rect.getMaxX());
			result = true;
		} if (this.getMaxY() < rect.getMaxY()) {
			this.setMaxY(rect.getMaxY());
			result = true;
		}
		return result;
	}
	
	public Rectangle union(Rectangle rect) {
		Rectangle newRect = new Rectangle();
		if (this.getMinX() < rect.getMinX()) {
			newRect.setMinX(this.getMinX());
		} else {
			newRect.setMinX(rect.getMinX());
		}
		
		if (this.getMinY() < rect.getMinY()) {
			newRect.setMinY(this.getMinY());
		} else {
			newRect.setMinY(rect.getMinY());
		}
		
		if (this.getMaxX() > rect.getMaxX()) {
			newRect.setMaxX(this.getMaxX());
		} else {
			newRect.setMaxX(rect.getMaxX());
		}
		
		if (this.getMaxY() > rect.getMaxY()) {
			newRect.setMaxY(this.getMaxY());
		} else {
			newRect.setMaxY(rect.getMaxY());
		}
		return newRect;
	}
}
