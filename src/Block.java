import processing.core.PApplet;
import processing.core.PImage;

public class Block extends MovingImage {

	private PImage blockImage;
	
	public Block(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	public void setup(PApplet g) {
		blockImage = g.loadImage("block.png");
		blockImage.resize(blockSize, blockSize);
	}

	public void draw(PApplet g, int slide) {
		g.image(blockImage, (float) x + slide * sx, (float)y);
	}
	
	public void draw(PApplet g) {
		g.image(blockImage, (float) x, (float) y);
	}

}
