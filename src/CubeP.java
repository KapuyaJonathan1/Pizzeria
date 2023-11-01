import processing.core.PApplet;
import processing.core.PImage;

public class CubeP extends Portal {

	private PImage cubeP;
	
	public CubeP(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	public void setup(PApplet g) {
		cubeP = g.loadImage("CubePortal.png");
		cubeP.resize(blockSize, blockSize * 2);
	}
	
	public void draw(PApplet g, int slide) {
		g.image(cubeP, (float) x + slide*getSX(), (float) y);
	}

	public void draw(PApplet g) {
		g.image(getImage(), (float) x, (float) y);
	}
	
	public PImage getImage() {
		
		return cubeP;
		
	}
	
}
