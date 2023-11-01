
import processing.core.PApplet;
import processing.core.PImage;

public class SpiderP extends Portal {

	private PImage spiderP;
	
	public SpiderP(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	public void setup(PApplet g) {
		spiderP = g.loadImage("BallPortal.png");
		spiderP.resize(blockSize, blockSize * 2);
	}
	
	public void draw(PApplet g, int slide) {
		g.image(spiderP, (float) x + slide*getSX(), (float) y);
	}
	
	public void draw(PApplet g) {
		g.image(getImage(), (float) x, (float) y);
	}
	
	public PImage getImage() {
		
		return spiderP;
		
	}

}
