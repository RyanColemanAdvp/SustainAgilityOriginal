import java.awt.*; 
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*; 

public class Bucket {

	//variables for the Paddle class, coordinates plus the width and height
	int x;
	int y;
	int width;
	int height;
	public boolean pressedRight;
	public boolean pressedLeft;
		
	//boolean gameActive;
	//constructor for the Paddle Class
	public Bucket(int x, int y, int w, int h){
		this.x = x;
		this.y = y;
		width = w;
		height = h;
	}
	
	
	//code that follows are getter and setter member functions for the Paddle class
	public void setX(int x){
		this.x = x;
	}
	public int getX(){
		return x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public int getY(){
		return y;
	}
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	public void setPosition(int x, int y){
		this.x = x;
		this.y = y;
	}
	public boolean getpressedLeft(){
		return pressedLeft;
	}
	public void setpressedLeft(boolean left){
		pressedLeft = left;
	}
	public void setpressedRight(boolean right){
		pressedRight = right;
	}
	//code used to move the paddle
	//the function determines when to move the paddle based on the true or falseness of the boolean variables
	//pressedLeft and pressedRight
	//sets limits to how far right or left the paddle can go
	public void move(){
		if (pressedLeft == true){
			x -= 4;
			if(x < 2){
				x = 2;
				pressedLeft = false;
			}
		}
		else if(pressedRight == true){
			x += 4;
			if(x > 770){
				x = 770;
				pressedRight = false;
			}
		}
	}

	public void keyPressed(KeyEvent e){
		
		
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			pressedLeft = true;
		}
		
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			pressedRight = true;
		}
    
	}

	public void keyReleased(KeyEvent e){
		
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			pressedLeft = false;
		}
		
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			pressedRight = false;
		}
	}
	
	public void paint(Graphics g){

		 Graphics2D  graphicsObject = (Graphics2D) g;
		 graphicsObject.setColor(Color.RED);
		 graphicsObject.fillRect(x, y, width, height);
		 graphicsObject.drawRect(x, y, width, height);
	}

	public Rectangle getPoints(){
		
		return new Rectangle(x,y,width,height);
	}


	
}
