
import java.awt.Rectangle;

import processing.core.PApplet;
import processing.core.PImage;

public class Portal extends MovingImage {

	private Rectangle rect;
	
	private PImage image;
	
	public Portal(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		
		rect = new Rectangle(x + width - 5, y, 10, height);
		
	}

	public void setImage(PImage image) {
		this.image = image;
	}
	
	public PImage getImage() {
		return image;
	}
	
	public Rectangle getRect() {
		
		rect = new Rectangle(getX() + width/2 - 5, getY(), 10, height);
		
		return rect;
	}
	
	public void disappear() {
		
		rect = null;
		image = null;
		
	}
	
	public void setup(PApplet g) {

	}
	
	public void draw(PApplet g, int slide) {
		g.image(image, (float) x + slide * sx, (float) y);
	}
	
	public void draw(PApplet g) {
		g.image(getImage(), (float) x, (float) y);
	}

}
