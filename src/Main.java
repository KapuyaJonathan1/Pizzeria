

import java.awt.event.KeyEvent;


import processing.core.*;

public class Main extends PApplet {
	
	private Menu menu = new Menu();
	
	private Song song = new Song();
	
	private MapMenu mapMenu = new MapMenu();
	
	private int blockSize = 48;
	
	private int sx = blockSize * 21, sy = blockSize * 15;
	
	private int ms = 210;
	
	private Map map = new Map(ms, true, this);
	
	private Builder builder;
	
	private Character character;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("Main");
	}
	
	public void settings() {
		
		size(sx, sy);
		
	}
	
	public void setup() {
		
		song.setFile();
		song.play();
		song.loop();
		
		menu.setup(this);
		
		mapMenu.setup(this);
		
		builder = new Builder(ms);
		
		character = new Character(blockSize * 2, blockSize * 8, blockSize, blockSize, map);
		character.setup(this);
		
	}
	
	public void draw() {
		
		if(menu.game() && !menu.mapMenu()) {
		
			drawGame();
		
		if(character.getDead()) {
			
			menu.setMenu(this);
			reset();
			
		}
		
		} else if(menu.builder() && !menu.mapMenu()) {
			
			builder.draw(mouseX, mouseY, this);
			
		} else if(menu.mapMenu()) {
			
			mapMenu.draw(this);
			checkMap();
			
		}	else if(menu.menu()) {
			
			menu.draw(this);
			
		} else if(menu.instructions()) {
			
			drawInstructions();
			
		}
		
	}
	
	private void checkMap() {
		// TODO Auto-generated method stub
		if(mapMenu.map() != 0) {
			map.setup(mapMenu.map());
			if(menu.game())
				menu.play();
			else if(menu.builder())
				menu.build();
				builder.setup(this, map);
		}
	}

	private void drawProgressBar() {
		
		push();
		fill(0,0,0);
		rect(sx/4, blockSize, sx/2, 20);
		fill(0, 255, 0);
		rect(sx/4, blockSize, (int)(((double)character.getXP()/ms) * sx/2), 20);
		pop();
	}
	
	private void drawInstructions() {
		
		push();
		fill(0, 0, 0);
		rect(0, 0, sx, sy);
		pop();
		
		text("Game: \n"
				+ "Click/Space bar to jump \n"
				+ "M to return to menu \n"
				+ "R to reset game", sx/3 - 100, sy/2 - 25);
		
		text("Builder: \n"
				+ "E/Q to switch tool \n"
				+ "M to return to menu \n"
				+ "d/a to scroll through map \n"
				+ "p to return code", sx - sx/3 - 100, sy/2 - 30);
		
	}
	
	private void drawGame() {
		// TODO Auto-generated method stub
		
		push();
		
		fill(200, 50, 200);
		
		rect(0, 0, sx, sy);
		
		pop();
		
		map.draw(this, character.getXP());
		
		map.move();
		
		character.checkCollisions(map);
		
		character.draw(this);
		
		character.move(map.getMovingCharacter());
		
		checkWin();
		
		drawProgressBar();
		
	}

	private void checkWin() {
		// TODO Auto-generated method stub
		
		if(character.getX() > sx - blockSize * 2) {
			
			menu.setMenu(this);
			
			reset();
			
		}
		
	}

	public void keyPressed() {
		
		if(menu.game()) {
			
			if(key == 'r') {
				reset();
			} else if(key == 'm') {
				reset();
				menu.setMenu(this);
				mapMenu = new MapMenu();
				mapMenu.setup(this);
			} else if(key == KeyEvent.VK_SPACE) {
				character.click();
			}
 			
		} else if(menu.builder()) {
			
			if(key == 'd') {
				builder.slideUp();
			} else if(key == 'a') {
				builder.slideDown();
			} else if(key == 'p') {
				builder.returnCode();
			} else if(key == 'e') {
				builder.modeUp();
			} else if(key == 'q') {
				builder.modeDown();
			} else if(key == 'v') {
				builder.xUp();
			} else if(key == 'c') {
				builder.xDown();
			} else if(key == 'x') {
				builder.yUp();
			} else if(key == 'z') {
				builder.yDown();
			} else if(key == 'm') {
				reset();
				menu.setMenu(this);
				mapMenu = new MapMenu();
				mapMenu.setup(this);
			}

		} else if(menu.instructions()) {
			if(key == 'm') {
				reset();
				menu.setMenu(this);
				mapMenu = new MapMenu();
				mapMenu.setup(this);
			}
		} else if(menu.mapMenu()) {
			
			if(key == 'm') {
				reset();
				menu.setMenu(this);
				mapMenu = new MapMenu();
				mapMenu.setup(this);
			}
			
		}
		
	}
	
	public void keyReleased() {
		if(menu.game()) {
			if(key == KeyEvent.VK_SPACE) {
				character.unclick();
			}
		}
	}
	
	public void reset() {
		
		character = new Character(blockSize * 2, blockSize * 8, blockSize, blockSize, map);
		character.setup(this);
		
		map = new Map(ms, true, this);
		map.setup(mapMenu.map());
		
		builder = new Builder(ms);
		builder.setup(this, map);
		
		
	}
	
	public void mousePressed() {
		
		if(menu.mapMenu()) {
		
			for(int i = 0; i < mapMenu.getButtons().size(); i++) {
				
				if(mapMenu.getButtons().get(i).isClicked(mouseX, mouseY)) {
					
					mapMenu.getButtons().get(i).click();
					
				}
				
			}
			
		} else if(menu.game()) {
		
			character.click();
		
		} else if(menu.menu()) {
		
			for(int i = 0; i < menu.getButtons().size(); i++) {
				
				if(menu.getButtons().get(i).isClicked(mouseX, mouseY)) {
					
					menu.getButtons().get(i).click();
					
				}
				
			}
		} else if(menu.builder()) {
			
			builder.click();
			
		} 
		
	}
	
	public void mouseReleased() {
		
		if(menu.game()) {
		
		character.unclick();
		
		} else if(menu.builder()) {
			
			builder.unclick();
			
		}
		
	}
	

}
