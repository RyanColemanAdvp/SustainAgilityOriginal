import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;


public class Pixel extends JButton{
	private ImageIcon image1;
	private ImageIcon image2;
	private boolean clicked;
	private long delay;
	
	public Pixel()
	{
		image1 = new ImageIcon("src/white.jpeg");
		image2 = new ImageIcon("src/black.jpeg");
		clicked = false;
		setIcon(image1);
		Pixel pixel;
		setVisible(true);
		setOpaque(true);
	}
	
	public void switchImage(ArrayList<Pixel> clickedButtons) throws InterruptedException
	{
		
		if(!clicked)
		{
			//return;
		//if(getIcon().equals(image1))
		//{
			setIcon(image2);
			//pixels.remove(this);
		}
		//}
		
			try{
			Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
				System.out.println("Interrupted: " + e.getMessage());
			}
			
		//else
		//{
			if(!clicked)
			{
			//pixels.add(this);
			setIcon(image1);
			}
			
			try{
			Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
				System.out.println("Interrupted: " + e.getMessage());
			}
		//}		
			
	}
	
	public void clicked(ArrayList<Pixel> pixels)
	{

		clicked = !clicked;
		if(pixels.contains(this))
		{
			pixels.remove(this);
		}
		else
		{
			pixels.add(this);
		}
	}


}
