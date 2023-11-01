import processing.core.PApplet;
import processing.core.PImage;

public class ArrowP extends Portal {

	private PImage arrowP;
	
	public ArrowP(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	public void setup(PApplet g) {
		arrowP = g.loadImage("ArrowPortal.png");
		arrowP.resize(blockSize, blockSize * 2);
	}
	
	public void draw(PApplet g, int slide) {
		g.image(arrowP, (float) x + slide*getSX(), (float) y);
	}
	
	public void draw(PApplet g) {
		g.image(getImage(), (float) x, (float) y);
	}

	public PImage getImage() {
		
		return arrowP;
		
	}
	
}
