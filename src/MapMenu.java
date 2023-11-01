
import java.util.ArrayList;

import processing.core.PApplet;

public class MapMenu {

	int c1 = 50, c2 = 50, c3 = 50;
	
	int blockSize = 48;
	
	int sx = 1000, sy = blockSize * 15;

	private int map = 0;
	
	private Button map1;
	
	private Button map2;
	
	private Button map3;

	private ArrayList<Button> buttons = new ArrayList<Button>();

	public void setup(PApplet g) {
		
		map1 = new Button(sx/2 - 200 - 50, sy/2 - 50, 100, 100, "Map 1", g);
		map2 = new Button(sx/2 - 50, sy/2 - 50, 100, 100, "Map 2", g);
		map3 = new Button(sx/2 + 200 - 50, sy/2 - 50, 100, 100, "Map 3", g);
		
		buttons.add(map1);
		buttons.add(map2);
		buttons.add(map3);
		
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
			
			if(map1.getClick()) {
				
				map = 1;
				
			} else if(map2.getClick()) {
				
				map = 2;
				
			} else if(map3.getClick()) {
				
				map = 3;
				
			}
			
		}
		
	}
	
	public ArrayList<Button> getButtons() {
		
		return buttons;
		
	}
	
	public int map() {
		
		return map;
		
	}
	
}
