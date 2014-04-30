import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


@SuppressWarnings("serial")
public class LogInformationScreen extends JFrame {
	
	public LogInformationScreen(){
		setJFrameSettings();
		exitButton();
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
	
	private void exitButton(){
		
		final JButton exit = new JButton();
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dispose();//JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
		    	}
			});
				exit.setText("Exit");
		exit.setVisible(true);
		getContentPane().add(exit, BorderLayout.SOUTH);
	
	}

	
}
