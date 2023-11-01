import processing.core.PApplet;

public class Button {

	int x, y, width, height;
	
	PApplet g;
	
	String text;
	
	boolean clicked = false;
	
	public Button(int x, int y, int width, int height, String text, PApplet g) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		this.text = text;
		
		this.g = g;
		
	}
	
	public void draw() {
		
		g.rect(x, y, width, height);
		
		g.push();
		
		g.fill(0, 0, 0);
		
		g.text(text, x + 5, y + height/2);
		
		g.pop();
		
	}
	
	public boolean isClicked(int mouseX, int mouseY) {
		
		boolean c = false;
		
		if(mouseX > x && mouseX < x + width && mouseY > y && mouseY < y + height) {
			c = true;
		}
		
		return c;
		
	}
	
	public void click() {
		
		clicked = true;
		
	}
	
	public boolean getClick() {
		return clicked;
	}
	
	public int getX() {
		
		return x;

	}
	
	public int getY() {
		
		return y;

	}
	
	public int getWidth() {
		
		return width;

	}
	
	public int getHeight() {
		
		return height;

	}
	
}
