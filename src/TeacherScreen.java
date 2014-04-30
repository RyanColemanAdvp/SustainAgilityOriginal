import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class TeacherScreen extends JFrame{
	
	public TeacherScreen(){
		setJFrameSettings();
		setButtons();
	}
	
	private void setJFrameSettings() { 
		setPreferredSize(new Dimension(1000, 1000));
		setTitle("Teacher Screen");  //set the title
		pack();
		setResizable(false);  //otherwise the spacing is thrown off
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void setButtons(){
		exitButton();
		JPanel instructionPanel = instructionButton();
		JPanel studentLogPanel = studentLogButton();
		JPanel combinedPanel = new JPanel();
		
		combinedPanel.setLayout(new GridLayout(2,1));
        combinedPanel.add(studentLogPanel);
        combinedPanel.add(instructionPanel);
		getContentPane().add(combinedPanel, BorderLayout.CENTER);
	}
	
	private JPanel instructionButton(){
		final JButton teacher = new JButton();
		teacher.setFocusable(false); //this way the game can't get stuck on this after a reset
		teacher.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			  	JFrame gameRestart = new TeachingInstructions();
			  	gameRestart.setVisible(true);
		    	}
			});
		teacher.setText("Teaching Instructions");
		teacher.setVisible(true);
		
		JPanel bottomRight = new JPanel();
		bottomRight.setBackground(Color.CYAN);
		bottomRight.add(teacher);
		return bottomRight;
	}
	
	private JPanel studentLogButton(){
		final JButton teacher = new JButton();
		teacher.setFocusable(false); //this way the game can't get stuck on this after a reset
		teacher.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			  	JFrame gameRestart = new LogInformationScreen();
			  	gameRestart.setVisible(true);
		    	}
			});
		teacher.setText("Student Log");
		teacher.setVisible(true);
		
		JPanel bottomRight = new JPanel();
		bottomRight.setBackground(Color.GRAY);
		bottomRight.add(teacher);
		return bottomRight;
	}

	
	//sets the Exit Button
	private void exitButton(){
		
		final JButton exit = new JButton();
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			  	dispose(); //close current JFrame (Teacher Screen)
		    	}
			});
				exit.setText("Exit");
		exit.setVisible(true);
		getContentPane().add(exit, BorderLayout.PAGE_END);
	
	}
	
}