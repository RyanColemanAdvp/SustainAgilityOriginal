import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class LogIn extends JFrame{
	
	public LogIn(){
		setJFrameSettings();
		exitButton();
		saveLogInInfo();
		}
	
	private void setJFrameSettings() { 
		setPreferredSize(new Dimension(1000, 1000));
		//getContentPane().add(new gameItems(), BorderLayout.NORTH);  //adds the JPanel to the JFrame
		setTitle("LogIn Screen");  //set the title
		pack();
		setResizable(false);  //otherwise the spacing is thrown off
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void saveLogInInfo(){
		final JTextArea logIn = new JTextArea();
		logIn.setVisible(true);
		logIn.setText("Enter Name Here");
		final JButton saveButton = new JButton();
		saveButton.setFocusable(false); 
		
		saveButton.addActionListener(new ActionListener(){  //onclick
			public void actionPerformed(ActionEvent e) {
			  
				JFrame nextScreen = new StudentScreen(); //starts next Class
			  	nextScreen.setVisible(true); //makes it visible
		    	
				}
			});
		saveButton.setText("Save");
		saveButton.setVisible(true);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.MAGENTA);
		mainPanel.add(logIn);
		mainPanel.add(saveButton);
		
		getContentPane().add(mainPanel); 
	
	}
	
	
	//sets the Exit Button
		private void exitButton(){
			
			final JButton exit = new JButton();
			exit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
				  	dispose(); //close current JFrame (LogIn Screen)
			    	}
				});
					exit.setText("Exit");
			exit.setVisible(true);
			getContentPane().add(exit, BorderLayout.PAGE_END);
		
		}
}
