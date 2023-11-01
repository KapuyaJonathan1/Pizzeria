import java.util.ArrayList;

import processing.core.PApplet;

public class Builder {
	
	int blockSize = 48;
	
	int sx = blockSize * 21, sy = blockSize * 15;
	
	int mode = 0;

	int mapSize;
	
	int slide = 0;
	
	int blockSizeX = blockSize, blockSizeY = blockSize;
	
	private ArrayList<ArrayList<BounceDot>> bounceDots;	
	
	private ArrayList<ArrayList<BouncePad>> bouncePads;
	
	private ArrayList<ArrayList<Portal>> portals;
	
	private ArrayList<ArrayList<Block>> blocks;
	
	private ArrayList<ArrayList<Spike>> spikes;
	
	private ArrayList<ArrayList<Portal>> preportals;
	
	private ArrayList<ArrayList<Block>> preblocks;
	
	private ArrayList<ArrayList<Spike>> prespikes;
	
	private FlyP fp = new FlyP(0, 0, 0, 0);
	
	private ArrowP ap = new ArrowP(0, 0, 0, 0);;
	
	private SpiderP bp = new SpiderP(0, 0, 0, 0);;
	
	private CubeP cp = new CubeP(0, 0, 0, 0);;
	
	private Spike s = new Spike(0, 0, 0, 0);
	
	private Block b = new Block(0, 0, 0 ,0);
	
	private BounceDot bounceDot = new BounceDot(0, 0, 0, 0);
	
	private BouncePad bouncePad = new BouncePad(0, 0, 0, 0);
	
	boolean ss, sp, sb;
	
	boolean clicking = false;
	
	public Builder(int mapSize) {
		
		this.mapSize = mapSize;
		
	}
	
	public void setup(PApplet g, Map map) {
		
		b.setup(g);
		
		s.setup(g);
		
		cp.setup(g);
		
		bp.setup(g);
		
		ap.setup(g);
		
		fp.setup(g);
		
		bouncePad.setup(g);
		
		bounceDot.setup(g);
		
		bounceDots = new ArrayList<ArrayList<BounceDot>>();	
		
		bouncePads = new ArrayList<ArrayList<BouncePad>>();
		
		portals = new ArrayList<ArrayList<Portal>>();
		
		blocks = new ArrayList<ArrayList<Block>>();
	
		spikes = new ArrayList<ArrayList<Spike>>();
		
		preportals = new ArrayList<ArrayList<Portal>>();
		
		preblocks = new ArrayList<ArrayList<Block>>();
	
		prespikes = new ArrayList<ArrayList<Spike>>();
		
		instantiateArrayLists();

		preblocks = map.getBlocks();
		
		prespikes = map.getSpikes();
		
		preportals = map.getPortals();
		
	}
	
	private void instantiateArrayLists() {
		
		for(int i = 0; i < mapSize; i++) {
			
			portals.add(new ArrayList<Portal>());
			
			spikes.add(new ArrayList<Spike>());
			
			blocks.add(new ArrayList<Block>());
			
			preportals.add(new ArrayList<Portal>());
			
			prespikes.add(new ArrayList<Spike>());
			
			preblocks.add(new ArrayList<Block>());
			
		}
		
	}
	
	public void draw(int mouseX, int mouseY, PApplet g) {
		
		add(mouseX, mouseY, g);
		
		drawBackground(g);
			
		drawStuff(g);
		
		switch(mode) {
		
		case 0:
			g.push();
			g.fill(0, 0, 255, 30);
			g.rect((mouseX/blockSize) * blockSize, (mouseY/blockSize) * blockSize, blockSizeX, blockSizeY);
			g.pop();
		break;
		
		case 1:
			g.image(s.getImage(), (mouseX/blockSize) * blockSize, (mouseY/blockSize) * blockSize, blockSize, blockSize);
		break;
			
		case 2:
			g.image(fp.getImage(), (mouseX/blockSize) * blockSize, (mouseY/blockSize) * blockSize, blockSize, blockSize * 2);
		break;
			
		case 3:
			g.image(cp.getImage(), (mouseX/blockSize) * blockSize, (mouseY/blockSize) * blockSize, blockSize, blockSize * 2);
		break;

		case 4:
			g.image(bp.getImage(), (mouseX/blockSize) * blockSize, (mouseY/blockSize) * blockSize, blockSize, blockSize * 2);
		break;
			
		case 5:
			g.image(ap.getImage(), (mouseX/blockSize) * blockSize, (mouseY/blockSize) * blockSize, blockSize, blockSize * 2);
		break;
		
		case 6:
			g.push();
			g.fill(255, 0, 0, 30);
			g.rect((mouseX/blockSize) * blockSize, (mouseY/blockSize) * blockSize, blockSize, blockSize);
			g.pop();
		break;
		
	}

}
	
	private void drawStuff(PApplet g) {
		// TODO Auto-generated method stub
	
		for(int i = 0; i < portals.size(); i++) {
			for(int j = 0; j < portals.get(i).size(); j++) {
			
				portals.get(i).get(j).draw(g, -slide);
				
			}
		}

	
		for(int i = 0; i < blocks.size(); i++) {
			
			for(int j = 0; j < blocks.get(i).size(); j++) {
				
				blocks.get(i).get(j).draw(g, -slide);
				
			}
			
		}
		
		for(int i = 0; i < spikes.size(); i++) {
			
			for(int j = 0; j < spikes.get(i).size(); j++) {
				
				spikes.get(i).get(j).draw(g, -slide);
				
			}
			
		}
		
		for(int i = 0; i < preportals.size(); i++) {
			for(int j = 0; j < preportals.get(i).size(); j++) {
			
				preportals.get(i).get(j).draw(g);
				
			}
		}

	
		for(int i = 0; i < preblocks.size(); i++) {
			
			for(int j = 0; j < preblocks.get(i).size(); j++) {
				
				preblocks.get(i).get(j).draw(g);
				
			}
			
		}
		
		for(int i = 0; i < prespikes.size(); i++) {
			
			for(int j = 0; j < prespikes.get(i).size(); j++) {
				
				prespikes.get(i).get(j).draw(g);
				
			}
			
		}
	
	}

	private void drawBackground(PApplet g) {
		// TODO Auto-generated method stub
		g.push();
		
		g.fill(200, 50, 200);
		
		g.rect(0, 0, sx, sy);
		
		g.fill(0,0,0);
		
		g.rect(0, 0, 20, 20);
		
		g.fill(255, 255, 255);
		
		g.text(slide, 10, 12);
		
		g.pop();
		
	}

	public void addBlock(int mouseX, int mouseY, PApplet g) {
		
		Block block;
		
		mouseX = (mouseX/blockSize);
		mouseY = (mouseY/blockSize) * blockSize;
		
		if(mouseX < 0) {
			mouseX = 0;
		}
		
		block = new Block(mouseX * blockSize, mouseY, blockSize, blockSize);
		block.setup(g);
		
		blocks.get(mouseX).add(block);
		
	}
	
	public void addSpike(int mouseX, int mouseY, PApplet g) {
		
		Spike block;
		
		mouseX = (mouseX/blockSize);
		mouseY = (mouseY/blockSize) * blockSize;
		
		if(mouseX < 0) {
			mouseX = 0;
		}
		
		block = new Spike(mouseX * blockSize, mouseY, blockSize, blockSize);
		block.setup(g);
		
		spikes.get(mouseX).add(block);
		
	}
	
	public void addFPortal(int mouseX, int mouseY, PApplet g) {
		
		FlyP portal;

		mouseX = (mouseX/blockSize);
		mouseY = (mouseY/blockSize) * blockSize;
		
		portal = new FlyP(mouseX * blockSize, mouseY, blockSize, blockSize * 2);
		portal.setup(g);
		
		portals.get(mouseX).add(portal);
		
	}
	
	public void addSPortal(int mouseX, int mouseY, PApplet g) {
		
		SpiderP portal;

		mouseX = (mouseX/blockSize);
		mouseY = (mouseY/blockSize) * blockSize;
		
		portal = new SpiderP(mouseX * blockSize , mouseY, blockSize, blockSize * 2);
		portal.setup(g);
		
		portals.get(mouseX).add(portal);
		
	}
	
	public void addAPortal(int mouseX, int mouseY, PApplet g) {
		
		ArrowP portal;
		
		
		
		mouseX = (mouseX/blockSize);
		mouseY = (mouseY/blockSize) * blockSize;
		
		portal = new ArrowP(mouseX * blockSize, mouseY, blockSize, blockSize * 2);
		portal.setup(g);
		
		portals.get(mouseX).add(portal);
		
	}
	
	public void addCPortal(int mouseX, int mouseY, PApplet g) {
		
		CubeP portal;
		
		mouseX = (mouseX/blockSize);
		mouseY = (mouseY/blockSize) * blockSize;
		
		portal = new CubeP(mouseX * blockSize, mouseY, blockSize, blockSize * 2);
		portal.setup(g);
		
		portals.get(mouseX).add(portal);
		
	}
	
	public void slideUp() {
		
		if(slide < mapSize/21 - 1) {
			
			slide++;	
			
			move(-sx);

		}
	}
	
	private void move(int x) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < blocks.size(); i++) {
			
			for(int j = 0; j < blocks.get(i).size(); j++) {
				
				blocks.get(i).get(j).move(x, 0);
				
			}
			
		}
		
		for(int i = 0; i < portals.size(); i++) {
			
			for(int j = 0; j < portals.get(i).size(); j++) {
				
				portals.get(i).get(j).move(x, 0);
				
			}
			
		}
		
		for(int i = 0; i < spikes.size(); i++) {
			
			for(int j = 0; j < spikes.get(i).size(); j++) {
				
				spikes.get(i).get(j).move(x, 0);
				
			}
			
		}
		
		for(int i = 0; i < preblocks.size(); i++) {
			
			for(int j = 0; j < preblocks.get(i).size(); j++) {
				
				preblocks.get(i).get(j).move(x, 0);
				
			}
			
		}
		
		for(int i = 0; i < preportals.size(); i++) {
			
			for(int j = 0; j < preportals.get(i).size(); j++) {
				
				preportals.get(i).get(j).move(x, 0);
				
			}
			
		}
		
		for(int i = 0; i < prespikes.size(); i++) {
			
			for(int j = 0; j < prespikes.get(i).size(); j++) {
				
				prespikes.get(i).get(j).move(x, 0);
				
			}
			
		}
		
	}

	public void slideDown() {
		
		if(slide > 0) {
		
			slide--;

			move(sx);
		
		}
		
	}
	
	public void returnCode() {
		
		int l = 0;
		
		System.out.println("------------------------------------------");
		
		Block b;
		
		for(int i = 0; i < blocks.size(); i++) {
			
			for(int j = 0; j < blocks.get(i).size(); j++) {
			
				b = blocks.get(i).get(j);
				
					System.out.println("blocks.get(" + i + ").add(new Block(" + i + "* blockSize, " + b.getY()/blockSize + " * blockSize, " + b.getWidth() + ", " + b.getHeight() + "));");
				
				l++;
				
			}
			
		}
		
		Spike s;
		
		for(int i = 0; i < spikes.size(); i++) {
			
			for(int j = 0; j < spikes.get(i).size(); j++) {
			
				s = spikes.get(i).get(j);
				
					System.out.println("spikes.get(" + i + ").add(new Spike(" + i + "* blockSize, " + s.getY()/blockSize + " * blockSize, " + s.getWidth() + ", " + s.getHeight() + "));");
				
				l++;
				
			}
			
		}
		
		Portal p;
		
		for(int i = 0; i < portals.size(); i++) {
			
			for(int j = 0; j < portals.get(i).size(); j++) {
				
				l++;
			
				p = portals.get(i).get(j);
				
				if(p.getClass() == cp.getClass()) {
						System.out.println("portals.get(" + i + ").add(new CubeP(" + i + "* blockSize" + ", " + p.getY()/blockSize + " * blockSize, " + p.getWidth() + ", " + p.getHeight() + "));");
				} else if(p.getClass() == bp.getClass()) {
						System.out.println("portals.get(" + i + ").add(new SpiderP(" + i + "* blockSize" + ", " + p.getY()/blockSize + " * blockSize, " + p.getWidth() + ", " + p.getHeight() + "));");
				} else if(p.getClass() == fp.getClass()) {
						System.out.println("portals.get(" + i + ").add(new FlyP(" + i + "* blockSize" + ", " + p.getY()/blockSize + " * blockSize, " + p.getWidth() + ", " + p.getHeight() + "));");
				} else if(p.getClass() == ap.getClass()) {
						System.out.println("portals.get(" + i + ").add(new ArrowP(" + i + "* blockSize" + ", " + p.getY()/blockSize + " * blockSize, " + p.getWidth() + ", " + p.getHeight() + "));");
				}
			}
			
		}		
		
		for(int i = 0; i < preblocks.size(); i++) {
			
			for(int j = 0; j < preblocks.get(i).size(); j++) {
			
				b = preblocks.get(i).get(j);

				System.out.println("blocks.get(" + i + ").add(new Block(" + i + "* blockSize, " + b.getY()/blockSize + " * blockSize, " + b.getWidth() + ", " + b.getHeight() + "));");
				
				l++;
				
			}
			
		}
		
		for(int i = 0; i < prespikes.size(); i++) {
			
			for(int j = 0; j < prespikes.get(i).size(); j++) {
			
				s = prespikes.get(i).get(j);
				
				System.out.println("spikes.get(" + i + ").add(new Spike(" + i + "* blockSize, " + s.getY()/blockSize + " * blockSize, " + s.getWidth() + ", " + s.getHeight() + "));");
				
				l++;
				
			}
			
		}
		
		for(int i = 0; i < preportals.size(); i++) {
			
			for(int j = 0; j < preportals.get(i).size(); j++) {
				
				l++;
			
				p = preportals.get(i).get(j);
				
				if(p.getClass() == cp.getClass()) {
					
						System.out.println("portals.get(" + i + ").add(new CubeP(" + i + "* blockSize" + ", " + p.getY()/blockSize + " * blockSize, " + p.getWidth() + ", " + p.getHeight() + "));");
						
				} else if(p.getClass() == bp.getClass()) {

						System.out.println("portals.get(" + i + ").add(new SpiderP(" + i + "* blockSize" + ", " + p.getY()/blockSize + " * blockSize, " + p.getWidth() + ", " + p.getHeight() + "));");
					
				} else if(p.getClass() == fp.getClass()) {

						System.out.println("portals.get(" + i + ").add(new FlyP(" + i + "* blockSize" + ", " + p.getY()/blockSize + " * blockSize, " + p.getWidth() + ", " + p.getHeight() + "));");
					
				} else if(p.getClass() == ap.getClass()) {

						System.out.println("portals.get(" + i + ").add(new ArrowP(" + i + "* blockSize" + ", " + p.getY()/blockSize + " * blockSize, " + p.getWidth() + ", " + p.getHeight() + "));");

				}
			}
			
		}
		
		System.out.println("Length: " + l);
		
	}

	public void xDown() {
		
		if(blockSizeX > blockSize) {
			blockSizeX -= blockSize;
		}
		
	}
	
	public void xUp() {

			blockSizeX += blockSize;
		
	}
	
	public void yUp() {

			blockSizeY += blockSize;
		
	}
	
	public void yDown() {
		
		if(blockSizeY > blockSize) {
			blockSizeY -= blockSize;
		}
		
	}
	
	public void modeUp() {
		
		if(mode < 6) {
			mode++;
		} else {
			mode = 0;
		}
		
	}
	
	public void modeDown() {
		
		if(mode > 0) {
			mode--;
		} else {
			mode = 6;
		}
		
	}
	
	public void add(int mouseX, int mouseY, PApplet g) {
		// TODO Auto-generated method stub
		
		mouseX += slide * sx;
		
		if(!spotTaken(mouseX, mouseY) && clicking) {
		
			switch(mode) {
			
				case 0:
					addBlock(mouseX, mouseY, g);
				break;
				
				case 1:
					addSpike(mouseX, mouseY, g);
				break;
					
				case 2:
					addFPortal(mouseX, mouseY, g);
				break;
					
				case 3:
					addCPortal(mouseX, mouseY, g);
				break;
	
				case 4:
					addSPortal(mouseX, mouseY, g);
				break;
					
				case 5:
					addAPortal(mouseX, mouseY, g);
				break;
	
			}
		
		} else {
			if(mode == 6 && clicking) {
				remove(mouseX, mouseY);
			}
		}
		
	}
	
	public void remove(int x, int y) {
		// TODO Auto-generated method stub
		
		if(spotTaken(x, y)) {
			
			if(ss) {
				
				for(int i = 0; i < spikes.get(x/blockSize).size(); i++) {
				
					if(spikes.get(x/blockSize).get(i).getY()/blockSize == y/blockSize) {
						
						spikes.get(x/blockSize).remove(i);
						
					}
					
				}
				
				for(int i = 0; i < prespikes.get(x/blockSize).size(); i++) {
					
					if(prespikes.get(x/blockSize).get(i).getY()/blockSize == y/blockSize) {
						
						prespikes.get(x/blockSize).remove(i);
						
					}
					
				}
				
			} else if(sp) {
				
				for(int i = 0; i < portals.get(x/blockSize).size(); i++) {
					
					if(portals.get(x/blockSize).get(i).getY()/blockSize == y/blockSize) {
						
						portals.get(x/blockSize).remove(i);
						
					}
					
				}
				
				for(int i = 0; i < preportals.get(x/blockSize).size(); i++) {
					
					if(preportals.get(x/blockSize).get(i).getY()/blockSize == y/blockSize) {
						
						preportals.get(x/blockSize).remove(i);
						
					}
					
				}
				
			} else if(sb) {
				
				for(int i = 0; i < blocks.get(x/blockSize).size(); i++) {
					
					if(blocks.get(x/blockSize).get(i).getY()/blockSize == y/blockSize) {
						
						blocks.get(x/blockSize).remove(i);
						
					}
					
				}
				
				for(int i = 0; i < preblocks.get(x/blockSize).size(); i++) {
					
					if(preblocks.get(x/blockSize).get(i).getY()/blockSize == y/blockSize) {
						
						preblocks.get(x/blockSize).remove(i);
						
					}
					
				}
				
			}
			
		}
		
	}

	
	public boolean spotTaken(int x, int y) {
		
		int bps = 21;
		
		int mx = x/sx;
		
		if(mx > mapSize - 23) {
			mx = mapSize - 23;
		}
		
		mx *= bps;
		
		for(int i = mx; i < mx + bps; i++) {
			
			for(int j = 0; j < blocks.get(i).size(); j++) {
				
				if(blocks.get(i).get(j).getX()/blockSize == x/blockSize && blocks.get(i).get(j).getY()/blockSize == y/blockSize) {
					
					sb = true;
					sp = false;
					ss = false;
					
					return true;
					
				}
				
			}
			
		}
		
		for(int i = mx; i < mx + bps; i++) {
			
			for(int j = 0; j < portals.get(i).size(); j++) {
				
				if(portals.get(i).get(j).getX()/blockSize == x/blockSize && portals.get(i).get(j).getY()/blockSize == y/blockSize) {
					
					sb = false;
					sp = true;
					ss = false;
					
					return true;
					
				}
				
			}
			
		}
		
		for(int i = 0; i < spikes.size(); i++) {
			
			for(int j = 0; j < spikes.get(i).size(); j++) {
				
				if(spikes.get(i).get(j).getX()/blockSize == x/blockSize && spikes.get(i).get(j).getY()/blockSize == y/blockSize) {
					
					sb = false;
					sp = false;
					ss = true;
					
					return true;
					
				}
				
			}
			
		}
		
		for(int i = 0; i < preblocks.size(); i++) {
			
			for(int j = 0; j < preblocks.get(i).size(); j++) {
				
				if(preblocks.get(i).get(j).getX()/blockSize == x % sx/blockSize && preblocks.get(i).get(j).getY()/blockSize == y/blockSize) {
					
					sb = true;
					sp = false;
					ss = false;
					
					return true;
					
				}
				
			}
			
		}
		
		for(int i = 0; i < preportals.size(); i++) {
			
			for(int j = 0; j < preportals.get(i).size(); j++) {
				
				if(preportals.get(i).get(j).getX()/blockSize == x % sx/blockSize && preportals.get(i).get(j).getY()/blockSize == y/blockSize) {
					
					sb = false;
					sp = true;
					ss = false;
					
					return true;
					
				}
				
			}
			
		}
		
		for(int i = 0; i < spikes.size(); i++) {
			
			for(int j = 0; j < prespikes.get(i).size(); j++) {
				
				if(prespikes.get(i).get(j).getX()/blockSize == x % sx/blockSize && prespikes.get(i).get(j).getY()/blockSize == y/blockSize) {
					
					sb = false;
					sp = false;
					ss = true;
					
					return true;
					
				}
				
			}
			
		}
		
		return false;
		
	}

	public void click() {
		// TODO Auto-generated method stub
		clicking = true;
	}
	
	public void unclick() {
		
		clicking = false;
		
	}
	
}
