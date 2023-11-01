
import java.util.ArrayList;

import processing.core.PApplet;

public class Menu {

	int c1 = 50, c2 = 50, c3 = 50;
	
	int blockSize = 48;
	
	int sx = 1000, sy = blockSize * 15;
	
	private boolean game = false;
	
	private boolean build = false;
	
	private boolean menu = true;
	
	private boolean instructions = false;
	
	private boolean mapMenu = false;
	
	private Button gameButton;
	
	private Button buildButton;
	
	private Button instructionsButton;
	
	private ArrayList<Button> buttons = new ArrayList<Button>();

	public void setup(PApplet g) {
		
		gameButton = new Button(sx/2 - 200 - 50, sy/2 - 50, 100, 100, "PLAY", g);
		buildButton = new Button(sx/2 + 200 - 50, sy/2 - 50, 100, 100, "BUILD", g);
		instructionsButton = new Button(sx/2 - 50, sy/2 - 50, 100, 100, "INSTRUCTIONS", g);
		
		buttons.add(gameButton);
		buttons.add(buildButton);
		buttons.add(instructionsButton);
		
	}
	
	public void draw(PApplet g) {

		int c = (int)(Math.random() * 3);
		
		if(c == 0) {
			c1++;
		} else if(c == 1) {
			c2++;
		} else {
			c3++;
		}
		
		c1 %= 120;
		c2 %= 255;
		c3 %= 255;
		
		g.background(c1, c2, c3);
		
		for(int i = 0; i < buttons.size(); i++) {
			
			buttons.get(i).draw();
			
			if(gameButton.getClick()) {
				
				mapMenu = true;
				game = true;
				build = false;
				menu = false;
				instructions = false;
				
			} else if(buildButton.getClick()) {
				
				mapMenu = true;
				build = true;
				game = false;
				menu = false;
				instructions = false;
				
			} else if(instructionsButton.getClick()) {
				
				mapMenu = false;
				build = false;
				game = false;
				menu = false;
				instructions = true;
				
			}
			
		}
		
	}
	
	public ArrayList<Button> getButtons() {
		
		return buttons;
		
	}
	
	public boolean game() {
		
		return game;
		
	}
	
	public boolean instructions() {
		
		return instructions;
		
	}
	
	public boolean builder() {
		
		return build;
		
	}
	
	public boolean menu() {
		
		return menu;
		
	}
	
	public void setMenu(PApplet g) {
		
		menu = true;
		
		game = false;
		
		build = false;
		
		instructions = false;
		
		mapMenu = false;
		
		gameButton = new Button(sx/2 - 200 - 50, sy/2 - 50, 100, 100, "PLAY", g);
		buildButton = new Button(sx/2 + 200 - 50, sy/2 - 50, 100, 100, "BUILD", g);
		instructionsButton = new Button(sx/2 - 50, sy/2 - 50, 100, 100, "INSTRUCTIONS", g);
		
		buttons = new ArrayList<Button>();
		
		buttons.add(gameButton);
		buttons.add(buildButton);
		buttons.add(instructionsButton);
		
	}

	public boolean mapMenu() {
		// TODO Auto-generated method stub
		return mapMenu;
	}

	public void play() {
		// TODO Auto-generated method stub
		game = true;
		menu = false;
		mapMenu = false;
		instructions = false;
		build = false;
	}
	
	public void build() {
		game = false;
		menu = false;
		mapMenu = false;
		instructions = false;
		build = true;
	}

	public void setMapMenu() {
		// TODO Auto-generated method stub
		game = false;
		menu = false;
		mapMenu = true;
		instructions = false;
		build = false;
	}
	
}
