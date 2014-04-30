import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Drip {

	private int x;
	private int y;
	private int ySpd = 1;
	int diameter;

	
	private Image drip;
	
	//constructor for the Drip class
	public Drip(int x, int y, int d){
		
		this.x = x;
		this.y = y;
		diameter = d;
		ImageIcon img = new ImageIcon();
		drip = img.getImage();
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getDiameter(){
		return diameter;
	}
	public void setY(int y){
		this.y = y;
	}
	public void setX(int x){
		this.x = x;
	}
	public void setDiameter(int d){
		diameter = d;
	}
	
	public void paint(Graphics g)
    {
		Graphics2D  graphicsObject = (Graphics2D) g;
		 graphicsObject.setColor(Color.BLUE);
		 graphicsObject.fillOval(x, y, diameter, diameter);
		 graphicsObject.drawOval(x, y, diameter, diameter);
    }
	
	//returns the image of the drip when called
	public Image getDrip(){
		return drip;
	}
	
	public void dripMove(){
		
		y += ySpd;
		
	}
	
	public Rectangle getPoints(){
		return new Rectangle(x,y,diameter,diameter); 
	}
}
