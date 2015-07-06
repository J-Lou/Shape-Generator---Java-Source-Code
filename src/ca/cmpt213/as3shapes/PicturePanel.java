package ca.cmpt213.as3shapes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PicturePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Canvas canvas;

	public PicturePanel(String title, int width, int height) {
		super();
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
		add(makeLabel(title), BorderLayout.NORTH);
		add(secondMakeLabel(width, height));
	}
	
	private Component secondMakeLabel(int width, int height) {
		canvas = new Canvas(width, height);
		CanvasIcon icon = new CanvasIcon(canvas);
		return new JLabel(icon);
	}
	
	private Component makeLabel(String title) {
		JLabel label = new JLabel(title);
		return label;
	}
	
	public void add(Shape shape) {
		shape.draw(canvas);
	}
}
