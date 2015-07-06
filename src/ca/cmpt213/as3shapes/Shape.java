package ca.cmpt213.as3shapes;

import java.awt.Color;

/*
 * Shape interface
 */
public interface Shape {

	public int getLocationX();
	
	public int getLocationY();
	
	public void setBorderChar(char c);
	
	public char getBorderChar();
	
	public void setColor(Color c);
	
	public Color getColor();
	
	public void draw(Canvas canvas);

}
