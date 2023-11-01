
import processing.core.PApplet;
import processing.core.PImage;

public class Spike extends MovingImage {

	private PImage spike;
	
	public Spike(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	public void setup(PApplet g) {
		
		spike = g.loadImage("spike.png");
		spike.resize(blockSize, blockSize);
		
	}
	
	public void draw(PApplet g, int slide) {
		
		g.image(spike, (float)x + slide*getSX(), (float)y);
		
	}
	
	public void draw(PApplet g) {
		g.image(getImage(), (float) x, (float) y);
	}
	
	public PImage getImage() {
		
		return spike;
		
	}


}
