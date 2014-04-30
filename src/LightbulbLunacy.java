
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;














import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



@SuppressWarnings("serial")
public class LightbulbLunacy extends JFrame implements Game, Runnable{
	
	private JPanel board;
	private JPanel extraOptionsArea;
	private JButton exit;
	private JButton restart;
	private Pixel pixel1;
	private ArrayList<Pixel> pixels;
	private ArrayList<Pixel> unclickedButtons;
	private Thread animator;
	
	private ArrayList<Integer> randoms;
	
	
	public LightbulbLunacy(){
		setTitle("Lightbulb Lunacy");
		pixels = new ArrayList<Pixel>();
		getContentPane().setLayout(new BorderLayout());
		gameJPanel();
		randoms = new ArrayList<Integer>();
		unclickedButtons = new ArrayList<Pixel>();
		setExtraFeatures();
		setPreferredSize(new Dimension(1000, 1000));
		pack();
		setResizable(false);  //otherwise the spacing is thrown off
		setLocationRelativeTo(null);
		createGameObjects();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	@Override
	public void addNotify(){
		super.addNotify();
		animator = new Thread(this);
		animator.start();
		setFocusable(true);
	}
	
	private void setExtraFeatures(){
		extraOptionsArea = new JPanel();
		exitButton();
		restartButton();
		getContentPane().add(extraOptionsArea, BorderLayout.EAST);
	}
	
	private void gameJPanel(){
		board = new JPanel();
		board.setBackground(Color.YELLOW);
		getContentPane().add(board, BorderLayout.CENTER);
	}
	
	private void restartButton(){
		restart = new JButton();
		restart.setFocusable(false); //this way the game can't get stuck on this after a reset
		restart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			  	dispose();
				JFrame gameRestart = new LightbulbLunacy();
			  	gameRestart.setVisible(true);
		    	}
			});
		restart.setText("Restart");
		restart.setSize(100,100);
		restart.setVisible(true);
		extraOptionsArea.add(restart);
		
	}
	
	
	/*
	 * Exit button.  On click closes the whole frame
	 */
	
	private void exitButton(){
		
		exit = new JButton();
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dispose();//JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
		    	}
			});
		exit.setText("Exit");
		exit.setVisible(true);
		exit.setSize(100,100);
		extraOptionsArea.add(exit);
	
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

		
		board.setLayout(new GridLayout(3,3));
		for(int i = 0; i < 9; i++)
		{
			final Pixel pixel = new Pixel();
			//pixel.run();
			
			pixel.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					pixel.clicked(pixels);
			    	}
				});
			board.add(pixel);
			pixels.add(pixel);
			unclickedButtons.add(pixel);
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{

//				try{
//				Thread.sleep(2);
//				}
//				catch(InterruptedException e)
//				{
//					System.out.println("Interrupted: " + e.getMessage());
//				}

//			System.out.println();
//			
//			for(int i = 0; i < pixels.size(); i++){
				Integer random = (Integer)(int)(Math.random()*pixels.size());
//				if(randoms.size() == pixels.size())
//				{
//					randoms.clear();
//				}
//				while(randoms.contains(random))
//						{//||
//						//!(unclickedButtons.contains(pixels.get(random))))
//				
//
//				random = (int)(Math.random()*pixels.size());
//				}
//
//				randoms.add(random);
//				
//				
				//System.out.println(random);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					if(pixels.size() == 0)
						break;
					pixels.get(random).switchImage(unclickedButtons);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
//			}

			//notifyAll();
			
//			accounts for time passed in delay

			
//			if(sleep < 0)
//			{
//				sleep = 1;
//			}
//			
//			try{
//				Thread.sleep(sleep);
//			}
//			catch(InterruptedException e)
//			{
//				System.out.println("Interrupted: " + e.getMessage());
//			}
			
//			beforeTime = System.currentTimeMillis();
		}
		
		
	
	}



}
