import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class WelcomeScreen extends JFrame{

		/*
		 * default constructor sets the JFrame specifications
		 */
		public WelcomeScreen(){
			
			setJframeSettings();
			setButtons();
			exitButton();

		}

		/*
		 * specifications for the JFrame
		 */
		private void setJframeSettings() { 
			setPreferredSize(new Dimension(1000, 1000));
			setTitle("Welcome!");  //set the title
			pack();
			setResizable(false);  //otherwise the spacing is thrown off
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		
		//combines the student/teacher option buttons (already stored in Panels) into one JPanel and puts it in Grid Layout
		private void setButtons(){
			JPanel One = studentButton();
			JPanel Two = teacherButton();
			JPanel Combine = new JPanel();
			
			Combine.setLayout(new GridLayout(2,1));
	        Combine.add(One);
	        Combine.add(Two);
			getContentPane().add(Combine, BorderLayout.CENTER);
		}
		
		//the teacher would enter the application here
		private JPanel teacherButton(){
			final JButton teacher = new JButton();
			teacher.setFocusable(false); 
			
			teacher.addActionListener(new ActionListener(){  //onclick
				public void actionPerformed(ActionEvent e) {
				  
					JFrame nextScreen = new TeacherScreen(); //starts next Class
				  	nextScreen.setVisible(true); //makes it visible
			    	
					}
				});
			teacher.setText("Teacher");
			teacher.setVisible(true);
			
			JPanel bottomHalf = new JPanel();
			bottomHalf.setBackground(Color.MAGENTA);
			bottomHalf.add(teacher);
			return bottomHalf; //setButtons will implement this
		
		}
		
		private JPanel studentButton(){
			final JButton student = new JButton();
			student.setFocusable(false); //this way the game can't get stuck on this after a reset
			student.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
				  	JFrame studentSelection = new LogIn();
				  	studentSelection.setVisible(true);
			    	}
				});
		
			student.setText("Student");
			student.setVisible(true);
			
			JPanel topHalf = new JPanel();
			topHalf.setBackground(Color.GREEN);
			topHalf.add(student);
			return topHalf; //set buttons will implement this
		
		}
		
		
		/*
		 * Exit button.  On click closes the whole frame
		 */
		
		private void exitButton(){
			
			final JButton exit = new JButton();
			exit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
				  	System.exit(0);
			    	}
				});
					exit.setText("Exit");
			exit.setVisible(true);
			getContentPane().add(exit, BorderLayout.SOUTH);
		
		}
		
		/*
		 * main() calls a thread that starts the application
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable(){
				@Override
				public void run(){
					JFrame start = new WelcomeScreen();  //initialize this screen
					start.setVisible(true);
				}
			});
		
		}
	}
