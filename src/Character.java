import java.awt.Rectangle;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Character extends MovingImage {

	private int speed;
	
	private int blockSize = 48;
	
	private int range = 0;
	
	private boolean onBlock = false;
	
	private boolean onBlockUpsideDown = false;
	
	private boolean wentUp = false;
	
	private boolean fly = false, jump = true, arrow = false, spider = false;;
	
	private int flyCounter = 0;
	
	boolean up = false;
	
	private double dx = 0, dy = 0;

	private int characterTrackerX = blockSize * 2;
	
	private int xp = 2;
	
	private PImage cubeImage;
	
	private PImage upsideDownCubeImage;
	
	private PImage shipImage;
	
	private PImage arrowImage;
	
	private PImage ballImage;
	
	private PImage currentImage;
	
	private FlyP fp;
	
	private ArrowP ap;
	
	private CubeP cp;
	
	private SpiderP sp;
	
	private boolean goingUp = false;
	
	private boolean jumpFinished = false;
	
	private boolean clicking = false;

	private boolean dead = false;
	
	private ArrayList<Block> currentBlocks;
	
	public Character(int x, int y, int width, int height, Map map) {
		super(x, y, width, height);
		speed = map.getSpeed();
	}
	
	public void setup(PApplet g) {
		
		ap = new ArrowP(0, 0, 0, 0);
		fp = new FlyP(0, 0, 0, 0);
		cp = new CubeP(0, 0, 0, 0);
		sp = new SpiderP(0, 0, 0, 0);
		
		cubeImage = g.loadImage("character.png");
		cubeImage.resize(blockSize, blockSize);
		
		upsideDownCubeImage = g.loadImage("upsideDownCube.png");
		upsideDownCubeImage.resize(blockSize, blockSize);
		
		shipImage = g.loadImage("ship.png");
		shipImage.resize((int) (blockSize * 1.5), blockSize);
		
		ballImage = g.loadImage("Ball.png");
		ballImage.resize(blockSize, blockSize);
		
		arrowImage = g.loadImage("Arrow.png");
		arrowImage.resize(blockSize, blockSize);
		
		currentImage = cubeImage;

	}
	
	public void checkCollisions(Map map) {
		
		ArrayList<ArrayList<Block>> blocks = map.getBlocks();
		ArrayList<ArrayList<Portal>> portals = map.getPortals();
		ArrayList<ArrayList<Spike>> spikes = map.getSpikes();
		
		currentBlocks = getCurrentBlocks(blocks);
		
		xp = (int)(characterTrackerX/blockSize);

		range = (int) (dy + 2);

		onBlock = checkOnBlock();
			
		if(spider) {
			
			onBlockUpsideDown = checkOnBlockUpsideDown();
			
			if(onBlockUpsideDown || onBlock) {
				dy = 0;
			}
			
		}
		
		checkTP();
		
		checkDeath(spikes);
		
		checkPortals(portals);
		
}
	
	private void checkDeath(ArrayList<ArrayList<Spike>> spikes) {
		// TODO Auto-generated method stub
		if(y > sy || y < 0) {
			dead = true;
		}
		
		for(int i = 0; i < currentBlocks.size(); i++) {
			if(intersects(currentBlocks.get(i).getRect())) {
				dead = true;
			}
		}
		
		for(int i = 0; i < spikes.size(); i++) {
			for(int j = 0; j < spikes.get(i).size(); j++) {
				if(intersects(spikes.get(i).get(j).getRect()) && spikeMath()) {
					dead = true;

				}
			}
		}
	}

	private boolean spikeMath() {
		// TODO Auto-generated method stub
		
		boolean sm = true;
		
		if(characterTrackerX % blockSize < blockSize/2) {
			
			if(blockSize - y % blockSize > characterTrackerX % blockSize * 2) {
				sm = false;
			}
			
		}
		
		return sm;
		
	}
	
	private void checkPortals(ArrayList<ArrayList<Portal>> portals) {
		// TODO Auto-generated method stub
		for(int i = 0; i < portals.size(); i++) {
			for(int j = 0; j < portals.get(i).size(); j++) {
				
				if(getRect().intersects(portals.get(i).get(j).getRect())) {
				
					if(portals.get(i).get(j).getClass() == fp.getClass()) {
						
						fly = true;
	
						flyCounter = 1;
						
						if(dy < -5) {
							dy = -5;
						}
						
						setImage(shipImage);
						
						portals.get(i).get(j).disappear();
						
						jump = false;
						arrow = false;
						spider = false;
						
						
					} else if(portals.get(i).get(j).getClass() == cp.getClass()) {
						
						jump = true;
						
						if(onBlock) {
							jumpFinished = true;
						}
						
						setImage(cubeImage);
						
						portals.get(i).get(j).disappear();
						
						fly = false;
						arrow = false;
						spider = false;
						
						
					} else if(portals.get(i).get(j).getClass() == ap.getClass()) {
						
						arrow = true;

						setImage(arrowImage);
						
						portals.get(i).get(j).disappear();
						
						fly = false;
						jump = false;
						spider = false;
		
					} else if(portals.get(i).get(j).getClass() == sp.getClass()) {
						
						spider = true;
						
						up = false;
						
						jumpFinished = true;
						
						setImage(cubeImage);
						
						portals.get(i).get(j).disappear();
						
						fly = false;
						jump = false;
						arrow = false;
		
					}
				}
			}
		}
	}

	private void checkTP() {
		
			for(int i = 0; i < currentBlocks.size(); i++) {
				if(y + blockSize + range > currentBlocks.get(i).getY() && y + blockSize < currentBlocks.get(i).getY() && wentUp) {
					y = (int)(y/blockSize)*blockSize + blockSize;
					onBlock = true;
					dy = 0;
					jumpFinished = true;
					goingUp = false;
					wentUp = false;
					flyCounter = 1;
				}
			}
			
			if(spider) {
				for(int i = 0; i < currentBlocks.size(); i++) {
					if(y + dy - 2 < currentBlocks.get(i).getY() + blockSize && y > currentBlocks.get(i).getY() + blockSize) {
						y = (int)(y/blockSize)*blockSize;
						onBlockUpsideDown = true;
						dy = 0;
						
					}
				}
			}
	}
	
	private ArrayList<Block> getCurrentBlocks(ArrayList<ArrayList<Block>> blocks) {
		// TODO Auto-generated method stub
		
		ArrayList<Block> cb = new ArrayList<Block>();
		
		for(int i = xp; i < xp + 2; i++) {
			
			for(int j = 0; j < blocks.get(i).size(); j++) {
				
				cb.add(blocks.get(i).get(j));
				
			}
			
		}
		
		return cb;
		
	}

	public void setImage(String image) {
		
		if(image == "cube") {
			currentImage = cubeImage;
		} else if(image == "ship") {
			currentImage = shipImage;
		} else if(image == "arrow") {
			currentImage = ballImage;
		} else if(image == "ball") {
			currentImage = ballImage;
		}
		
	}
	
	public PImage getImage() {
		return currentImage;
	}
	
	private boolean checkOnBlock() {
		// TODO Auto-generated method stub
		boolean onBlock = false;
		
		for(int i = 0; i < currentBlocks.size(); i++) {
			if(y + blockSize == currentBlocks.get(i).getY()) {
				onBlock = true;
			}
		}
		
		if(!onBlock) {
			jumpFinished = false;
		}
		
		return onBlock;
	}

	private boolean checkOnBlockUpsideDown() {
		// TODO Auto-generated method stub
		boolean onBlock = false;
		
		for(int i = 0; i < currentBlocks.size(); i++) {
			if(y == currentBlocks.get(i).getY() + blockSize) {
				onBlock = true;
			}
		}
		
		return onBlock;
	}
	
	public void move(boolean b) {
		
		if(b) {
			dx = speed;
		}
		
		move(dx, dy);
		
		characterTrackerX += speed;
		
		if(jump && clicking || !jumpFinished && jump) {
			
			jump();
			
		} else if(fly) {
			
			fly();
			
		} else if(arrow) {
			
			arrow();
			
		} else if(spider) {
			
			spider();
			
		}
}
	
	public void spider() {
		
		if(clicking) {
			
			unclick();
			
			if(onBlock || onBlockUpsideDown) {
				up = !up;
				teleportSpider();
			}

		}
		
		if(!up) {
			if(!onBlock) {
				wentUp = true;
				dy += 1;
			}
		} else {
			if(!onBlockUpsideDown) {
				dy -= 1;
			}
		}
		
	}
	
	private void teleportSpider() {
		// TODO Auto-generated method stub
		
		int pd;
		
		if(up) {

			onBlockUpsideDown = true;
			
			setImage(upsideDownCubeImage);
			
			pd = -sy;
			
			for(int i = 0; i < currentBlocks.size(); i++) {
				
				if(currentBlocks.get(i).getY() + blockSize < y && (currentBlocks.get(i).getY() + blockSize - y) > pd) {
					
					pd = (int) (currentBlocks.get(i).getY() - y + blockSize);
					
				}
				
			}
			
		} else {
			
			onBlock = true;
			
			setImage(cubeImage);
			
			pd = sy;
			
			for(int i = 0; i < currentBlocks.size(); i++) {
				
				if(currentBlocks.get(i).getY() > this.y && Math.abs(y - currentBlocks.get(i).getY()) < pd) {
					
					pd = (int) (currentBlocks.get(i).getY() - y - blockSize);
					
				}
				
			}
			
		}
		
		move(0, pd);
		
		onBlock = true;
		
	}

	public void bounce() {
		
		dy += 6;
		
	}
	
	public void fly() {
		
		if(clicking) {
			dy -= 0.4;
			checkWentUp();
		} else {
			if(!onBlock) {
				wentUp = true;
				dy += 0.4;
			}
		}
		
	}
	
	private void checkWentUp() {
		// TODO Auto-generated method stub
		if(flyCounter == 1) {
			dy -= 1;
			flyCounter = 0;
		}
		if(dy < -1) {
			wentUp = true;
		}
		
	}

	public void jump() {
		
		wentUp = true;
		
		if(jumpFinished) {
			 if(dy == 0 && !goingUp) {
				 dy = -15;
				 goingUp = true;
				 jumpFinished = false;
			 }
		} else {
			dy++;
		}
			 
	}

	
	public void arrow() {
		
		if((blockSize - y/blockSize) > dy + 2) {
			wentUp = true;
		}
		
		if(clicking) {
			dy = 5;
		} else {
			dy = -5;
		}
		
	}
	
	public void move(double x, double y) {

		this.x += x;
		this.y += y;

		rect = new Rectangle((int)this.x, (int)this.y, width, height);
		
	}

	public void setImage(PImage image) {
		currentImage = image;
	}
	
	public void draw(PApplet g) {
		g.image(currentImage, (float)x, (float)y);
		
	}

	public void click() {
		clicking = true;
	}
	
	public void unclick() {
		clicking = false;
	}
	
	public boolean getDead() {
		return dead;
	}

	public int getXP() {
		// TODO Auto-generated method stub
		return xp;
	}

}
