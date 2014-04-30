
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class InsulationInsanity extends JFrame {
	public InsulationInsanity(){
		setTitle("Insultation Insanity");
		gameJPanel();
		setExtraFeatures();
		setPreferredSize(new Dimension(1000, 1000));
		pack();
		setResizable(false);  //otherwise the spacing is thrown off
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void setExtraFeatures(){
		JButton exit = exitButton();
		JButton restart = restartButton();
		JPanel extraOptionsArea = new JPanel();
		extraOptionsArea.add(exit);
		extraOptionsArea.add(restart);
		getContentPane().add(extraOptionsArea, BorderLayout.PAGE_END);
	}
	
	private void gameJPanel(){
		JPanel waterGame = new JPanel();
		waterGame.setBackground(Color.GRAY);
		getContentPane().add(waterGame, BorderLayout.CENTER);
	}
	
	private JButton restartButton(){
		final JButton restart = new JButton();
		restart.setFocusable(false); //this way the game can't get stuck on this after a reset
		restart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			  	dispose();
				JFrame gameRestart = new InsulationInsanity();
			  	gameRestart.setVisible(true);
		    	}
			});
		restart.setText("Restart");
		restart.setVisible(true);
		return restart;
	}
	
	
	/*
	 * Exit button.  On click closes the whole frame
	 */
	
	private JButton exitButton(){
		
		final JButton exit = new JButton();
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dispose();//JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
		    	}
			});
				exit.setText("Exit");
		exit.setVisible(true);
		return exit;
	
	}

}
