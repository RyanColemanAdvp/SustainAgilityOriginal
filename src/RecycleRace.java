
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class RecycleRace extends JFrame implements KeyListener{
	//Member Variables
	public RecycleGame recycleRaceBoard = new RecycleGame();
	
	//Constructor
	public RecycleRace(){
		initUI();
	}
	
	public void initUI(){
		//Add Recycle Game Board
		add(recycleRaceBoard);
		
		//Set attributes
		setSize(1000, 1000);
		setTitle("Recycle Race");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setFocusable(true);
		addKeyListener(this);
		requestFocusInWindow();
		setExtraFeatures();
		
	}
	
	//Main function creates a new instance of the JFrame object to start the game
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run(){
				JFrame animateGame = new RecycleRace();
				animateGame.setVisible(true);
			}
		});
	
	}
	
	private void setExtraFeatures(){
		JButton exit = exitButton();
		JButton restart = restartButton();
		JPanel extraOptionsArea = new JPanel();
		extraOptionsArea.add(exit);
		extraOptionsArea.add(restart);
		getContentPane().add(extraOptionsArea, BorderLayout.PAGE_END);
	}
	
	private JButton restartButton(){
		final JButton restart = new JButton();
		restart.setFocusable(false); //this way the game can't get stuck on this after a reset
		restart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			  	dispose();
				JFrame gameRestart = new RecycleRace();
			  	gameRestart.setVisible(true);
		    	}
			});
		restart.setText("Restart");
		restart.setVisible(true);
		return restart;
	}
	
	private JButton exitButton(){
		
		final JButton exit = new JButton();
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dispose();
		    	}
			});
				exit.setText("Exit");
		exit.setVisible(true);
		return exit;
	
	}
	
	public class RecycleGame extends JPanel implements Game, Runnable{
		private WasteContainer garbageBin = new WasteContainer(1);
		private WasteContainer aluminumBin = new WasteContainer(2);
		private WasteContainer paperBin = new WasteContainer(3);
		private WasteContainer plasticBin = new WasteContainer(4);
		private WasteContainer glassBin = new WasteContainer(5);
		public ObjectToThrowAway fallingPiece;
		private final int BOARD_WIDTH = 1000;
		private final int BOARD_HEIGHT = 1000;
		private final int INITIAL_X = 500;
		private final int INITIAL_Y = -100;
		private final int DELAY = 25;
		public int arrowPress = 0;
		private Thread animator;
		public boolean isTrashFalling = true;
		int x, y, xDir, yDir;
		
		
		public class WasteContainer {
			private int type;
			private int itemCount;
			
			WasteContainer(int i){
				type = i;
			}
			public void setType(int i){
				type = i;
			}
			public int getType(){
				return type;
			}
			public int itemCount(){
				return itemCount;
			}
			public void addItem(){
				itemCount++;
			}
		}
		
		public class ObjectToThrowAway {
			private int type;
			ObjectToThrowAway(int i){
				type = i;
			}
			public void setType(int i){
				type = i;
			}
		
			public int getType(){
				return type;
			}
		}
		
		public RecycleGame(){
			initBoard();
			
			//http://stackoverflow.com/questions/299495/how-to-add-an-image-to-a-jpanel
			BufferedImage bkgimage = null;
			try {
				bkgimage = ImageIO.read(new File("stonebkg.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void initBoard(){
			//Randomize trash piece but if bucket is full don't make one of those type
			//http://stackoverflow.com/questions/5887709/getting-random-numbers-in-java
			int trashType = 0;
			while (true){
				Random rand = new Random();
				trashType = rand.nextInt(5) + 1;
				
				if (trashType == 1 && garbageBin.itemCount < 3){
					break;
				}
				if (trashType == 2 && aluminumBin.itemCount < 3){
					break;
				}
				if (trashType == 3 && paperBin.itemCount < 3){
					break;
				}
				if (trashType == 4 && plasticBin.itemCount < 3){
					break;
				}
				if (trashType == 5 && glassBin.itemCount < 3){
					break;
				}
			}
			
			fallingPiece = new ObjectToThrowAway(trashType);
			
			x = INITIAL_X;
			y = INITIAL_Y;				
			xDir = 0;
			yDir = 1;
		}

		@Override
		public void addNotify(){
			super.addNotify();
			animator = new Thread(this);
			animator.start();
		}
		
		@Override
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			drawShapes(g);
			//g.drawImage(bkgimage, 0, 0, null);
		}
		
		//Method to draw all shapes on the board
		public void drawShapes(Graphics g){
			//Draw piece of falling trash
			Graphics2D trash = (Graphics2D) g;
			if (fallingPiece.getType() == 1){
				trash.setPaint(Color.green);
			}
			else if (fallingPiece.getType() == 2){
				trash.setPaint(Color.red);
			}
			else if (fallingPiece.getType() == 3){
				trash.setPaint(Color.blue);
			}
			else if (fallingPiece.getType() == 4){
				trash.setPaint(Color.orange);
			}
			else if (fallingPiece.getType() == 5){
				trash.setPaint(Color.cyan);
			}
			trash.fillOval(x, y, 50, 50);
			trash.drawOval(x, y, 50, 50);
			
			//Draw garbage bin
			Graphics2D garbage = (Graphics2D) g;
			if (garbageBin.itemCount() < 3){
				garbage.setPaint(Color.green);
			}
			else{
				garbage.setPaint(Color.black);
			}
			garbage.fillRect(0, 840, 200, 100);
			garbage.drawRect(0, 840, 200, 100);
			
			//Draw aluminum recycle bin
			Graphics2D aluminum = (Graphics2D) g;
			if (aluminumBin.itemCount() < 3){
				aluminum.setPaint(Color.red);
			}
			else{
				aluminum.setPaint(Color.black);
			}
			aluminum.fillRect(200, 840, 200, 100);
			aluminum.drawRect(200, 840, 200, 100);
			
			//Draw paper recycle bin
			Graphics2D paper = (Graphics2D) g;
			if (paperBin.itemCount() < 3){
				paper.setPaint(Color.blue);
			}
			else{
				paper.setPaint(Color.black);
			}
			paper.fillRect(400, 840, 200, 100);
			paper.drawRect(400, 840, 200, 100);
			
			//Draw plastic recycle bin
			Graphics2D plastic = (Graphics2D) g;
			if (plasticBin.itemCount() < 3){
				plastic.setPaint(Color.orange);
			}
			else{
				plastic.setPaint(Color.black);
			}
			plastic.fillRect(600, 840, 200, 100);
			plastic.drawRect(600, 840, 200, 100);
			
			//Draw glass recycle bin
			Graphics2D glass = (Graphics2D) g;
			if (glassBin.itemCount() < 3){
				glass.setPaint(Color.cyan);
			}
			else{
				glass.setPaint(Color.black);
			}
			glass.fillRect(800, 840, 200, 100);
			glass.drawRect(800, 840, 200, 100);
			
			
			Toolkit.getDefaultToolkit().sync();
			g.dispose();
		}
		
		public void movement(){
			x += xDir;
			y += yDir;
			xDir = 0;
		}
		
		@Override
		public void run() {
			long beforeTime, timeDiff, sleep;
			
			beforeTime = System.currentTimeMillis();
			
			while (true){
				//Call function to update trash piece movement
				movement();
				
				//Update diection of trash based on arrow key press
				if (arrowPress == -1){
					xDir = -3;
				}
				else if (arrowPress == 2){
					yDir = 5;
				}
				else if (arrowPress == 1){
					xDir = 3;
				}
				
				//Check to see which bin the trash landed in
				if (y > 860 && x > 0 && x < 200){
					if(fallingPiece.getType() == 1){
						garbageBin.addItem();
					}
					initBoard();
				}
				if (y > 860 && x > 200 && x < 400){
					if(fallingPiece.getType() == 2){
						aluminumBin.addItem();
					}
					initBoard();
				}
				if (y > 860 && x > 400 && x < 600){
					if (fallingPiece.getType() == 3){
						paperBin.addItem();
					}
					initBoard();
				}
				if (y > 860 && x > 600 && x < 800){
					if (fallingPiece.getType() == 4){
						plasticBin.addItem();
					}
					initBoard();
				}
				if (y > 860 && x > 800 && x < 1000){
					if (fallingPiece.getType() == 5){
						glassBin.addItem();
					}
					initBoard();
				}
				
				//Repaint frame
				repaint();
				
				timeDiff = System.currentTimeMillis();
				sleep = DELAY - timeDiff;
				
				//Controls the amount of time the thread sleeps for before reloading
				if (sleep < 0){
					sleep = 3;
				}
				
				//Try catch block to make the thread sleep
				try{
					Thread.sleep(sleep);
				}catch (InterruptedException e){
					System.out.println("Interrupted: " + e.getMessage());
				}
				beforeTime = System.currentTimeMillis();
			
			}
		}

		@Override
		public void incrementScore() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void incrementTime() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void createGameObjects() {
			// TODO Auto-generated method stub
			
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_LEFT){
			recycleRaceBoard.arrowPress = -1;
		}
		if (code == KeyEvent.VK_RIGHT){
			recycleRaceBoard.arrowPress = 1;
		}
		if (code == KeyEvent.VK_DOWN){
			recycleRaceBoard.arrowPress = 2;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_DOWN){
			recycleRaceBoard.arrowPress = 0;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
