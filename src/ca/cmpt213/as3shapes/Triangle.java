package ca.cmpt213.as3shapes;

/*
 * Implements drawing of triangle
 */

public class Triangle extends ShapeImpl {
	
	private int x;
	private int y;
	private int width;
	private int height;
	
	public Triangle(int x, int y, int base) {
		super(x, y, base, base);
		this.x = x;
		this.y = y;
		this.width = x+base-1;
		this.height = y+base-1;
		Canvas canvas = new Canvas(width, height);
		super.draw(canvas);
	}
	
	protected boolean isBorder(int x, int y) {
		int i = this.x;
		int j = this.y;
		if (x == this.x) {
			return true;
		} 
		
		if (y == height) {
			return true;
		}
		while ( (i < width) && (j < height)) {
			if ( (x == i) && (y == j) ) {
				return true;
			}
			i++;
			j++;
		}
		return false;		
	}
	

	protected boolean isInside(int x, int y) {	
		int i = this.x;
		int j = this.y;
		while (i < width) {
			if (x == this.x) {
				return false;
			}
			if ( (x < i) && (y == j)) {
				return true;
			}
			j++;
			i++;
		}	
		return false;		
	}	
}
