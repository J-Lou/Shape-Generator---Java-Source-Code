package ca.cmpt213.as3shapes;

import java.util.List;
import java.util.ArrayList;

/*
 * Implements text into a rectangle
 */
public class TextBox extends Rectangle{	
	private String text;
	private List<String> stringCollector = new ArrayList<>();
	private List<String> formattedStrings = new ArrayList<>();
	
	public TextBox(int x, int y, int width, int height, String text) {
		super(x, y, width, height);
		setMessage(text);
		Canvas canvas = new Canvas(width, height);
		super.draw(canvas);
	}
	
	public void setMessage(String s) {
		this.text = s;
		String message = formatText(s);
		textToList(message);
	}
	
	public String getMessage() {
		return text;
	}
	
	
	// Places the formatted text in list
	public void textToList(String message) {
		int rowLength = getWidth()-2;
		int columnLength = getHeight()-2;
		int start = 0;
		int c = 0;
		stringCollector.clear();
		StringBuilder sb = new StringBuilder();
		for(int j = 0; j < message.length(); j++) {
			if ( (message.charAt(j) == '\n') || (j == message.length()-1)) {
				String stringLine = message.substring(start, j+1).trim();
				start = j+1;
				stringCollector.add(stringLine);
				c++;
			}
			
			if (c == columnLength) {
				break;
			}
		}
		
		for (String s : stringCollector) {
			int spaces = (rowLength - s.length()) / 2;
			for(int i = 0; i < spaces; i++) {
				sb.append(' ');
			}
			sb.append(s);
			for(int i = 0; i < spaces; i++) {
				sb.append(' ');
			}
			formattedStrings.add(sb.toString());
			sb.setLength(0);
		}
	}
	
	// Formats the text by comparing it to the amount of room it has
	private String formatText(String text) {
		int lineLength = getWidth()-2;		
		int start = 0;			
		for(int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == ' ') {
				String word = text.substring(start, i);
				word = word.trim();
				start = i;
				stringCollector.add(word);
			} else if (i == text.length()-1) {
				String word = text.substring(start, i+1);
				word = word.trim();
				stringCollector.add(word);
			}
		}	
		
		// determines the amount of characters in the line
		int index = 0;
		int charCount = 0;
		int wordCount = 0;
		StringBuilder sb = new StringBuilder();
		StringBuilder leftover = new StringBuilder();
		StringBuilder checkEqualTwo = new StringBuilder();
		String checkEqualOne = null;
		while(stringCollector.size() > index) {
			charCount = stringCollector.get(index).length() + charCount + wordCount - 1
						+leftover.toString().length();
			sb.append(leftover.toString());
			int count = leftover.toString().length();
			leftover.setLength(0);
			if (charCount == lineLength) {
				int i = index - wordCount;
				while (i < index) {
					String word = stringCollector.get(i);
					sb.append(word);
					if (i != index) {
						sb.append(" ");
					}
					i++;
				}
				wordCount = 0;
				charCount = 0;
				sb.append("\n");
			} else if (charCount > lineLength) {
				int i = 0;
				i = index - wordCount;
				while (i < index) {
					String word = stringCollector.get(i);
					if (word.length() != 0) {
						if (i != index) {
							count = word.length() + count + 1;		
						} else {
							count = word.length() + count;
						}
						if (count-1 <= lineLength) {
							sb.append(word);
						} else if (count == lineLength) {
							sb.append(word);
						} else {
							leftover.append(word);
							leftover.append(" ");
						}
						if (i != index) {
							sb.append(" ");
						}
					}
					i++;
				}
				wordCount = 0;
				charCount = 0;
				sb.append("\n");
			} else if ( (charCount <= lineLength) && (index == stringCollector.size()-1) ) {
				int i = index - wordCount;
				while (i < index) {
					String word = stringCollector.get(i);
					sb.append(word);					
					if (i != index) {
						sb.append(" ");
					}		
					i++;
				}
				wordCount = 0;
				charCount = 0;
				sb.append(stringCollector.get(stringCollector.size()-1));
				sb.append("\n");
			} 
			index++;
			wordCount++;
		}
		// Wrap string to next line
		checkEqualOne = sb.toString().replaceAll("\\s+","");
		for (String s : stringCollector) {
			checkEqualTwo.append(s);
		}
		sb.append(leftover.toString());
		String lastString = stringCollector.get(stringCollector.size()-1);
		if (!(checkEqualTwo.toString().equalsIgnoreCase(checkEqualOne))) {
			if (lastString.length() > lineLength) {
				sb.append("\n");
				sb.append(lastString.substring(0, lineLength-1));
				sb.append("\n");
				sb.append(lastString.substring(lineLength, lastString.length()));	
			} else {	
				sb.append(stringCollector.get(stringCollector.size()-1));
			}
		}
		String returningString = sb.toString().trim();
		return returningString;
	}
		
	// draws out the rectangle and string
	@Override
	public void draw(Canvas canvas) {	
		int x = getLocationX();
		int y = getLocationY();
		int width = x + getWidth();
		int height = y + getHeight();
		int a = 0;
		int b = 0;
		char character = ' ';	
		for (int j = y; j < height; j++) {
			for (int i = x; i < width; i++) {
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
		for(String s : formattedStrings) {
			while (a < s.length()) {
				character = s.charAt(a);
				if (isInside(x+1+a, y+1+b)) {
					canvas.setPointText(x+1+a,y+1+b, character);
				}
				a++;
			}
			a = 0;
			b++;
		}
		formattedStrings.clear();
	}

}
