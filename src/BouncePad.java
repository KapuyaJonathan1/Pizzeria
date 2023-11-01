import processing.core.PApplet;
import processing.core.PImage;

public class BouncePad extends MovingImage {

	PImage pad;
	
	public BouncePad(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	public void setup(PApplet g) {
		
	//	pad = g.loadImage("bounceDot.png");
		//pad.resize(20,  20);
		
	}
	
	public void draw(PApplet g) {
		
		g.image(pad, (int)x, (int)y);
		
	}
}
