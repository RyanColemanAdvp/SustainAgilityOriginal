
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class TeachingInstructions extends JFrame {
	public TeachingInstructions(){
		setTitle("Water");
		setExtraFeatures();
		instructions();
		setPreferredSize(new Dimension(1000, 1000));
		pack();
		setResizable(false);  //otherwise the spacing is thrown off
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	private void setExtraFeatures(){
		JButton exit = exitButton();
		JPanel extraOptionsArea = new JPanel();
		extraOptionsArea.add(exit);
		getContentPane().add(extraOptionsArea, BorderLayout.PAGE_END);
	}
	
	
	private void instructions(){
		JPanel instructionScreen = new JPanel();
		JLabel instructions = new JLabel();
		instructions.setBackground(Color.WHITE);
		instructions.setFont(new Font("Serif", Font.BOLD, 25));
		instructions.setText("<html><br>INSRUCTIONS FOR THIS ARE COM INSRUCTIONS FOR THIS </br>"
				+ "<br>ARE COM INSRUCTIONS FOR THIS ARE COM INSRUCTIONS FOR THIS ARE COM INSRUCTIONS </br>"
				+ "<br>FOR THIS ARE COM INSRUCTIONS FOR THIS ARE COM</br> "
				+ "\nICATED ETC ETC DO THIS EC</html>");

		instructionScreen.add(instructions);
		
		getContentPane().add(instructionScreen);
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
