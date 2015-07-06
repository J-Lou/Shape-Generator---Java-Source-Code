package ca.cmpt213.as3shapes;

/*
 * Implements drawing of rectangle
 */
public class Rectangle extends ShapeImpl {
	
	private int x;
	private int y;
	private int width;
	private int height;
	
	public Rectangle(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.x = x;
		this.y = y;
		this.width = x+width-1;
		this.height = y+height-1;
		Canvas canvas = new Canvas(width, height);
		super.draw(canvas);
	}
	
	protected boolean isBorder(int x, int y) {
		if (x == this.x) {
			return true;
		} else if (x == width) {
			return true;
		}
		
		if (y == this.y) {
			return true;
		} else if (y == height) {
			return true;
		}

		return false;		
	}
	

	protected boolean isInside(int x, int y) {
		if (x < this.x+1) {
			return false;
		} else if (x > width-1) {
			return false;
		}
		
		if (y < this.y+1) {
			return false;
		} else if (y > height-1) {
			return false;
		}

		return true;		
	}
	
}
