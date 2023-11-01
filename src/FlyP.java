import processing.core.PApplet;
import processing.core.PImage;

public class FlyP extends Portal {

	private PImage flyP;
	
	public FlyP(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	public void setup(PApplet g) {
		flyP = g.loadImage("ShipPortal.png");
		flyP.resize(blockSize, blockSize * 2);
	}
	
	public void draw(PApplet g, int slide) {
		g.image(flyP, (float) x + slide*getSX(), (float) y);
	}
	
	public void draw(PApplet g) {
		g.image(getImage(), (float) x, (float) y);
	}

	public PImage getImage() {
		
		return flyP;
		
	}

}
