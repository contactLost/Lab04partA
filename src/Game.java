import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Game extends JFrame {

	final int FRAME_WIDTH = 500;
	final int FRAME_HEIGHT = 500; 
	
	private JButton[][] button;
	private JLabel label;
	private JFrame frame;
	private JPanel panel;
	
	public Game() {
		
		createComponents();

		add(panel);
		setVisible(true); 
		
		setTitle( "Game - ver ALPHA 0.01");
		setSize(FRAME_WIDTH, FRAME_HEIGHT); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	
	}

	public static void main(String[] args) {
		
		Game game = new Game();
	}
	
	public class ClickListener implements ActionListener

	{

	   public void actionPerformed(ActionEvent event)
	   {
	      System.out.println("I was clicked.");
	   }
	}
	
	private void createComponents() {
		
		button = new JButton[5][5];
		label = new JLabel("Hello, World!");
		panel = new JPanel();
		ActionListener listener = new ClickListener();
		listener.actionPerformed(null);
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				
				button[i][j] = new JButton(" ");
				button[i][j].addActionListener(listener);
				panel.add(button[i][j]);
			}
		}
	
		panel.add(label);
		
	}
}
