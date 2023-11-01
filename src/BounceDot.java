import processing.core.PApplet;
import processing.core.PImage;

public class BounceDot extends MovingImage {

	PImage dot;
	
	public BounceDot(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	public boolean isClicked(int characterX, int characterY) {
		
		boolean isClicked = false;
		
		if(characterX > x - blockSize && characterX < x + width + blockSize
			&& characterY > y - blockSize && characterY < y + height + blockSize) {
			
			isClicked = true;
			
		}
		
		return isClicked;
		
	}
	
	public void setup(PApplet g) {
		
		dot = g.loadImage("bounceDot.png");
		dot.resize(blockSize, 10);
	}
	
	public void draw(PApplet g) {
		
		g.image(dot, (int)x, (int)y);
		
	}
	
}
