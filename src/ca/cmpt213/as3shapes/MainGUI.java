package ca.cmpt213.as3shapes;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 * Test program showing a number of different shapes inside an icon.
 */
@SuppressWarnings("unused")
public class MainGUI {
	// Default size of the panels
	private static final int SIZE_X = 79;
	private static final int SIZE_Y = 24;
	
	
	/**
	 * Application to display the test "pictures" to the UI.
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));

		// Sample function showing use of Canvas and CanvasIcon.
		// Comment this out when you have later tests working.
		//frame.add(makeCanvasIcon());
		
		// Test routines to exercise Picture and the Shape classes.
		//frame.add(makeRectanglesPicture());
		//frame.add(makeTrianglesPicture());
		frame.add(makeTextBoxesPicture());
		//frame.add(makeMixedPicture());

		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	/**
	 * Demonstrate the Canvas class and the CanvasIcon and how to put it into the UI	
	 *  - Use a Canvas to "draw" some items.
	 *  - Use a CanvasIcon to render the Canvas in a graphical form.
	 *  - Use a JLabel to make it a component that can be easily added to the UI.
	 * @return A JLabel holding an icon to add to the UI.
	 */
	private static Component makeCanvasIcon() {
		// Create the canvas
		Canvas canvas = new Canvas(15, 20);
		
		// Draw characters onto the canvas
		canvas.setPointText(0, 0, 'S');
		canvas.setPointText(1, 1, '!');
		canvas.setPointText(canvas.getSizeX()-1, canvas.getSizeY()-1, 'B');
		
		// Setting colours in the canvas
		for (int i = 0; i < 5; i++) {
			canvas.setPointColor(i + 3, 8, Color.RED);
			canvas.setPointColor(5, i + 6, Color.GREEN);
		}
		
		// Setting colour and text:
		for (int i = 0; i < 5; i++) {
			int pos = i + 9;
			canvas.setPointColor(pos, pos, Color.YELLOW);
			canvas.setPointText(pos, pos, (char)('A' + i));
		}
		
		// Trying to draw off the canvas is just ignored
		// (useful when drawing a shape beyond the bounds of the canvas; you
		//  can ignore the fact that it's off the page!)
		canvas.setPointText(canvas.getSizeX(), canvas.getSizeY(), 'E');
		
		// Create an icon from the canvas and put it into a label
		CanvasIcon icon = new CanvasIcon(canvas);
		return new JLabel(icon);
	}

	
/*
	// //////////////////////////////////////////////////////////////////////////
	// Rectangle Test
	// //////////////////////////////////////////////////////////////////////////
	private static PicturePanel makeRectanglesPicture() {
		PicturePanel picture = new PicturePanel("Rectangle Picture Test:", 60, 19);
		testRectanglesRow1(picture);
		testRectangleRow2(picture);
		return picture;
	}

	private static void testRectanglesRow1(PicturePanel picture) {
		Rectangle r1 = new Rectangle(0, 0, 1, 1);
		r1.setColor(Color.MAGENTA);
		picture.add(r1);

		Rectangle r2 = new Rectangle(5, 0, 2, 2);
		r2.setBorderChar('*');
		r2.setColor(Color.GREEN);
		picture.add(r2);

		Rectangle r3 = new Rectangle(10, 0, 3, 3);
		r3.setColor(Color.RED);
		picture.add(r3);

		Rectangle r4 = new Rectangle(15, 0, 4, 4);
		picture.add(r4);

		Rectangle r5 = new Rectangle(27, 0, 35, 18);
		r5.setColor(Color.ORANGE);
		picture.add(r5);
	}

	private static void testRectangleRow2(PicturePanel picture) {
		final int ROW = 5;
		Rectangle r1 = new Rectangle(0, ROW, 5, 10);
		r1.setColor(Color.PINK);
		picture.add(r1);

		r1 = new Rectangle(10, ROW, 5, 10);
		r1.setColor(Color.LIGHT_GRAY);
		r1.setBorderChar('#');
		picture.add(r1);

		r1 = new Rectangle(20, ROW, 5, 10);
		r1.setColor(Color.RED);
		r1.setBorderChar('%');
		picture.add(r1);

		r1 = new Rectangle(30, ROW, 14, 49);
		r1.setColor(Color.GREEN);
		r1.setBorderChar('@');
		picture.add(r1);
	}
	*/
	/*
	// //////////////////////////////////////////////////////////////////////////
	// Triangle Test
	// //////////////////////////////////////////////////////////////////////////
	private static PicturePanel makeTrianglesPicture() {
		PicturePanel picture = new PicturePanel("Triangle Picture Test:", 50, 26);
		testTriangleRow1(picture);
		testTriangleRow2(picture);
		return picture;
	}

	private static void testTriangleRow1(PicturePanel picture) {
		Triangle t1 = new Triangle(0, 0, 1);
		t1.setColor(Color.CYAN);
		picture.add(t1);

		Triangle t2 = new Triangle(5, 0, 2);
		t2.setColor(Color.RED);
		picture.add(t2);

		Triangle t3 = new Triangle(10, 0, 3);
		t3.setColor(Color.MAGENTA);
		picture.add(t3);

		Triangle t4 = new Triangle(15, 0, 4);
		t4.setColor(Color.GREEN);
		picture.add(t4);

		Triangle t5 = new Triangle(27, 0, 18);
		t5.setColor(Color.LIGHT_GRAY);
		picture.add(t5);

		Triangle t6 = new Triangle(37, 2, 7);
		t6.setColor(Color.BLACK);
		picture.add(t6);
	}

	private static void testTriangleRow2(PicturePanel picture) {
		final int ROW = 10;
		Triangle t1 = new Triangle(0, ROW, 5);
		t1.setColor(Color.RED);
		picture.add(t1);

		t1 = new Triangle(10, ROW, 5);
		t1.setColor(Color.YELLOW);
		t1.setBorderChar('#');
		picture.add(t1);

		t1 = new Triangle(20, ROW, 5);
		t1.setColor(Color.GREEN);
		t1.setBorderChar('%');
		picture.add(t1);

		t1 = new Triangle(35, ROW, 5);
		t1.setColor(Color.RED);
		t1.setBorderChar('X');
		picture.add(t1);

		t1 = new Triangle(30, ROW, 16);
		t1.setBorderChar('@');
		picture.add(t1);

	}*/
	// //////////////////////////////////////////////////////////////////////////
	// TextBox Test
	// //////////////////////////////////////////////////////////////////////////
	private static PicturePanel makeTextBoxesPicture() {
		PicturePanel picture = new PicturePanel("Text Box Test:", SIZE_X, SIZE_Y);
		testTextBoxRow1(picture);
		testTextBoxRow2(picture);
		return picture;
	}

	private static void testTextBoxRow1(PicturePanel picture) {
		TextBox tb1 = new TextBox(0, 0, 14, 3, "Hello world!");
		tb1.setColor(Color.CYAN);
		picture.add(tb1);

		tb1 = new TextBox(0, 5, 16, 3, "Hello world!");
		tb1.setColor(Color.RED);
		picture.add(tb1);

		TextBox tb2 = new TextBox(20, 0, 9, 9,
				"And so it began, the great debugging!");
		tb2.setColor(Color.GREEN);
		picture.add(tb2);

		// Code Monkey Lyrics, by Jonathan Coulton
		// See: http://www.youtube.com/watch?v=qYodWEKCuGg
		TextBox tb3 = new TextBox(
				30,
				0,
				30,
				15,
				"Code Monkey get up get coffee. "
						+ "Code Monkey go to job. "
						+ "Code Monkey have boring meeting with boring manager Rob. "
						+ "Rob say Code Monkey very diligent, "
						+ "but his output stink. "
						+ "His code not functional or elegant. "
						+ "What do Code Monkey think? "
						+ "Code Monkey think maybe manager want to write goddamn login page himself. "
						+ "Code Monkey not say it out loud. "
						+ "Code Monkey not crazy just proud.");
		picture.add(tb3);

		TextBox tb4 = new TextBox(65, 5, 13, 10,
				"And there was much rejoicing!");
		tb4.setColor(Color.ORANGE);
		picture.add(tb4);
	}

	private static void testTextBoxRow2(PicturePanel picture) {
		// Test how well the text wraps
		final int ROW = 16;
		String alphabet = " a b c d e f g h i j k l m n o p q r s t u v w x y z"
				+ " A B C D E F G H I J K L M O P Q R S T U V W X Y Z ";
		TextBox tb1 = new TextBox(0, ROW, 8, 8, alphabet);
		tb1.setColor(Color.CYAN);
		picture.add(tb1);

		tb1 = new TextBox(9, ROW, 8, 8, alphabet);
		tb1.setColor(Color.GREEN);
		picture.add(tb1);

		tb1 = new TextBox(20, ROW, 7, 8, alphabet);
		tb1.setColor(Color.MAGENTA);
		picture.add(tb1);
		
		tb1 = new TextBox(30, ROW, 9, 8, alphabet);
		tb1.setColor(Color.LIGHT_GRAY);
		picture.add(tb1);
		
		tb1 = new TextBox(40, ROW, 9, 8, alphabet);
		tb1.setColor(Color.CYAN);
		tb1.setMessage("Hi yal!");
		tb1.setBorderChar('#');
		picture.add(tb1);
		
		tb1 = new TextBox(50, ROW, 9, 3, alphabet);
		tb1.setColor(Color.GREEN);
		tb1.setMessage("Hi yal!");
		tb1.setBorderChar('&');
		picture.add(tb1);
		
		tb1 = new TextBox(60, ROW, 20, 5, alphabet);
		tb1.setColor(Color.RED);
		tb1.setMessage("Hi yal!");
		tb1.setBorderChar('*');
		picture.add(tb1);
		
	}

	// //////////////////////////////////////////////////////////////////////////
	// Mixed Picture Test
	// //////////////////////////////////////////////////////////////////////////
	private static PicturePanel makeMixedPicture() {
		PicturePanel pic = new PicturePanel("Mixed Element Picture Test:", SIZE_X, SIZE_Y);
		
		// Add border
		Rectangle rect = new Rectangle(0, 0, SIZE_X, SIZE_Y);
		rect.setColor(Color.ORANGE);
		rect.setBorderChar('#');
		pic.add(rect);
		
		// Text box with styling:
		rect = new TextBox(45, 10, 30, 4, "A box!");
		rect.setColor(Color.RED);
		rect.setBorderChar('%');
		pic.add(rect);
		
		// Bunch of other shapes:
		Triangle shape2 = new Triangle(15, 2, 20);
		shape2.setColor(Color.CYAN);
		pic.add(shape2);

		Rectangle shape3 = new Rectangle(25, 8, 15, 8);
		shape3.setColor(Color.GREEN);
		pic.add(shape3);
		
		Triangle shape4 = new Triangle(54, 1, 5);
		shape4.setColor(Color.DARK_GRAY);
		pic.add(shape4);
		
		TextBox shape5 = new TextBox(2, 2, 3, 20, "Thin text in a box!");
		shape5.setColor(Color.YELLOW);
		pic.add(shape5);

		Rectangle shape6 = new Rectangle(72, 18, 5, 4);
		shape6.setColor(Color.MAGENTA);
		pic.add(shape6);

		return pic;
	}

}

