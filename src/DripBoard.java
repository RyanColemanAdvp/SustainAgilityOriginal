import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class DripBoard extends JPanel implements KeyListener, Runnable {
	
	Bucket bucket;
	Drip[] drips = new Drip [100];
	private Thread animator;
	private int score;
	private boolean running = true;
	private Timer timer;
	private int y;
	private int j = 0;
	
	
	public DripBoard(){
		
		initializeBoard();
		addKeyListener(this);
		setFocusable(true);
	}
	
	private void initializeBoard(){
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(800, 500));
		setDoubleBuffered(true);
		
		bucket = new Bucket(275, 375, 25, 60);
		
		
		for(int i = 0; i < 100; i++){
			int randomInt = (int)(780.0 * Math.random());
			drips[i] = new Drip(randomInt, 0, 5);
		}
	}
	
public void paintComponent(Graphics g){
		
		super.paintComponent(g);

		//drip.paint(g);
		bucket.paint(g);
		for (Drip d : drips){
			d.paint(g);
		}

		g.drawString("Use the bucket to collect the water", 30, 40);
		Toolkit.getDefaultToolkit().sync();
		
	}//end of paintComponent method

public void addNotify() {
    super.addNotify();
    animator = new Thread(this);
    animator.start();
} 

public void intersection(){
	for(int i = 0; i < 100; i++){
		if(bucket.getPoints().intersects(drips[i].getPoints())){
			drips[i].setDiameter(0);
			drips[i].setX(0);
			drips[i].setY(0);
			score++;
		}
	}
}

public void rainingDrips(int j){
	
	//y = j;
	y = 0;
	
	while(y < 100){
		drips[y].dripMove();
		break;
	}
	//j++;
	rainingDrips(j);
}
	@Override
	public void run() {
		while(running){
			for(int i = 0; i < 100; i++){
				drips[i].dripMove();
				break;
			}
			//rainingDrips(0);
			bucket.move();

			repaint();
			try{
				Thread.sleep(10);
			}
			catch(InterruptedException ie){
				
			}
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		e.getKeyCode();
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			bucket.setpressedLeft(true);
		}
		
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			bucket.setpressedRight(true);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			bucket.setpressedLeft(false);
		}
		
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			bucket.setpressedRight(false);
		}		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
