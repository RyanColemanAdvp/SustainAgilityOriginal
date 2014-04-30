import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


@SuppressWarnings("serial")
public class StudentScreen extends JFrame{
	
	public StudentScreen(){
		setJFrameSettings();
		setButtons();
		exitButton();
		//restartButton();
	}
	
	private void setJFrameSettings() { 
		setPreferredSize(new Dimension(1000, 1000));
		//getContentPane().add(new gameItems(), BorderLayout.NORTH);  //adds the JPanel to the JFrame
		setTitle("Student Screen");  //set the title
		pack();
		setResizable(false);  //otherwise the spacing is thrown off
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void setButtons(){
		JPanel One = waterWasteButton();
		JPanel Two = lighbulbLunacyButton();
		JPanel Three = recycleRaceButton();
		JPanel Four = insulationInsanityButton();
		JPanel Combine = new JPanel();
		
		//create a 2x2 grid
		Combine.setLayout(new GridLayout(2,2));
	  
		//add the 4 above panels to the main panel
		Combine.add(One);
        Combine.add(Two);
        Combine.add(Three);
        Combine.add(Four);
		getContentPane().add(Combine, BorderLayout.CENTER);
	}
	
	private JPanel waterWasteButton(){
		final JButton waterWaste = new JButton();
		waterWaste.setFocusable(false); //this way the game can't get stuck on this after a reset
		waterWaste.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
				//getContentPane().removeAll();
				JFrame gameSelection = new WaterWaste();
				gameSelection.setVisible(true);
			//	getContentPane().add(gameSelection, BorderLayout.CENTER);
				//revalidate();  //does the actual change
				//JFrame waterWasteScreen = new TeacherScreen();
			  	//waterWasteScreen.setVisible(true);
		    	}
			});
		waterWaste.setAlignmentX( 
				Component.CENTER_ALIGNMENT); 
		waterWaste.setText("Water Waste");
		waterWaste.setVisible(true);
		
		JPanel topLeft = new JPanel();
		topLeft.setBackground(Color.BLUE);
		topLeft.add(waterWaste);
		return topLeft;
		//getContentPane().add(waterWaste, BorderLayout.NORTH);
	}
	
	
	private JPanel lighbulbLunacyButton(){
		final JButton teacher = new JButton();
		teacher.setFocusable(false); //this way the game can't get stuck on this after a reset
		teacher.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			  	JFrame gameRestart = new LightbulbLunacy();
			  	gameRestart.setVisible(true);
		    	}
			});
		teacher.setText("Lighbulb Lunacy");
		teacher.setVisible(true);
		
		JPanel bottomRight = new JPanel();
		bottomRight.setBackground(Color.YELLOW);
		bottomRight.add(teacher);
		return bottomRight;
	}
	
	private JPanel insulationInsanityButton(){
		final JButton insulationButton = new JButton();
		insulationButton.setFocusable(false); //this way the game can't get stuck on this after a reset
		insulationButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			  	JFrame gameRestart = new InsulationInsanity();
			  	gameRestart.setVisible(true);
		    	}
			});
		insulationButton.setText("Insulation Insanity");
		insulationButton.setVisible(true);
		
		JPanel bottomRight = new JPanel();
		bottomRight.setBackground(Color.GRAY);
		bottomRight.add(insulationButton);
		return bottomRight;
	}
	
	private JPanel recycleRaceButton(){
		final JButton recycRaceButton = new JButton();
		recycRaceButton.setFocusable(false); //this way the game can't get stuck on this after a reset
		recycRaceButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			  	JFrame gameRestart = new RecycleRace();
			  	gameRestart.setVisible(true);
		    	}
			});
		recycRaceButton.setText("Recycle Race");
		recycRaceButton.setVisible(true);
		
		JPanel bottomLeft = new JPanel();
		bottomLeft.setBackground(Color.GREEN);
		bottomLeft.add(recycRaceButton);
		return bottomLeft;
	}
	
	/*
	 * Exit button.  On click closes the whole frame
	 */
	
	private void exitButton(){
		
		final JButton exit = new JButton();
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			  	dispose();
		    	}
			});
				exit.setText("Exit");
		exit.setVisible(true);
		getContentPane().add(exit, BorderLayout.PAGE_END);
	
	}
}