

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import processing.core.PImage;

public class MovingImage {
	
	Rectangle rect;
	PImage image;
	int width;
	int height;
	double x;
	double y;
	
	int blockSize = 48;
	
	int sx = blockSize * 21, sy = blockSize * 15;
	
	public MovingImage(int x, int y, int width, int height) {

		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		rect = new Rectangle(x, y, width, height);
		
		//CoordinateSystem coords = new CoordinateSystem(x, y, image);
		
	}
	
	public void move(double x, double y) {

		this.x += x;
		this.y += y;

		rect = new Rectangle((int)this.x, (int)this.y, width, height);
		
	}
	
	public int getX() {
		return (int)x;
	}
	
	public int getY() {
		return (int)y;
	}
	
	public int getSX() {
		return sx;
	}
	
	public int getSY() {
		return sy;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setWidth(int w) {
		width = w;
	}
	
	public void setHeight(int h) {
		height = h;
	}
	
	public Rectangle getRect() {
		return rect;
	}
	
	public void setRect(Rectangle rect) {
		this.rect = rect;
	}
	
	
	public boolean intersects(MovingImage other) {
		
		boolean intersects = false;
		
		if(this.getRect().intersects(other.getRect())) {
			intersects = true;
		}
		
		return intersects;
	}
	
	public boolean intersects(Rectangle other) {
		
		boolean intersects = false;
		
		if(this.getRect().intersects(other)) {
			intersects = true;
		}
		return intersects;
	}

	public PImage getImage() {
		return image;
	}
	
	public void setImage(PImage image) {
		
		this.image = image;
		
	}

	
}