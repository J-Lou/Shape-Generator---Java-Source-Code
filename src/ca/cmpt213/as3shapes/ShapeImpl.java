package ca.cmpt213.as3shapes;

import java.awt.Color;

/*
 * Implements the shape interface
 */

public abstract class ShapeImpl implements Shape{
	
	private int locationX;
	private int locationY;
	
	private char borderChar = '*';
	private Color color = Color.YELLOW;
	int width;
	int height;
	
	public ShapeImpl(int x, int y, int width, int height) {
		setLocationX(x);
		setLocationY(y);
		setWidth(width);
		setHeight(height);
	}
	
	private void setLocationX(int x) {
		this.locationX = x;
	}
	
	private void setLocationY(int y) {
		this.locationY = y;
	}
	
	@Override
	public int getLocationX() {
		return locationX;
	}

	@Override
	public int getLocationY() {
		return locationY;
	}

	@Override
	public void setBorderChar(char c) {
		this.borderChar = c;
		
	}

	@Override
	public char getBorderChar() {
		return borderChar;
	}

	@Override
	public void setColor(Color c) {
		this.color = c;
	}

	@Override
	public Color getColor() {
		return color;
	}
	
	private void setWidth(int width) {
		this.width = width;
	}
	
	private void setHeight(int height) {
		this.height = height;
	}
	
	protected int getWidth() {
		return width;
	}
	
	protected int getHeight() {
		return height;
	}

	@Override
	public void draw(Canvas canvas) {
		int x = getLocationX();
		int y = getLocationY();
		int width = x + getWidth();
		int height = y + getHeight();
		
		for (int i = x; i < width; i++) {
			for (int j = y; j < height; j++) {
				if (isBorder(i, j)) {
					canvas.setPointColor(i, j, getColor());
					canvas.setPointText(i, j, getBorderChar());
				}
				if (isInside(i, j)) {
					canvas.setPointColor(i, j, getColor());
					canvas.setPointText(i, j, ' ');
				}
				
			}
		}
	}
		
	
	protected abstract boolean isBorder(int x, int y);
	
	protected abstract boolean isInside(int x ,int y);

}
