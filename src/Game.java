import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Game extends JFrame {

	final int FRAME_WIDTH = 350;
	final int FRAME_HEIGHT = 500; 
	

	private gameButton[][] button;
	private static JLabel label;
	private JFrame frame;
	private JPanel panel;

	public Game() {
		createComponents();

		add( panel);
		setVisible( true); 

		setTitle( "Game - ver ALPHA 0.2");
		setSize( FRAME_WIDTH, FRAME_HEIGHT); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

	}

	public static void main( String[] args ) throws InterruptedException {
		
		Game game = new Game();	
		
		while(true) {
			
			if( gameButton.isGameOver() ) {
				label.setText("Attempts: " + gameButton.attempts + " Game Over");
			}
			else{
				label.setText("Attempts: " + gameButton.attempts + " " + gameButton.gameCondition);
			}
		}
	}

	

	private void createComponents() {

		int prizeLocation = randomNumberGenerate(); //TODO bunların hepsi array olsun
		int firstBombLocation = randomNumberGenerate();
		while(prizeLocation == firstBombLocation) { firstBombLocation = randomNumberGenerate(); }
		int secondBombLocation = randomNumberGenerate();
		while((prizeLocation == secondBombLocation) || (firstBombLocation == secondBombLocation) ) { secondBombLocation = randomNumberGenerate(); }
		
		System.out.println(prizeLocation);
		System.out.println(firstBombLocation);
		System.out.println(secondBombLocation);
		
		button = new gameButton[5][5];
		label = new JLabel( "Hello, World!" + gameButton.attempts );
		panel = new JPanel();

		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {

				boolean placed = false;
				
				if( ( (int) (prizeLocation / 5) + 1 == i) && (prizeLocation % 5 == j)) { //Row && Column for prize
					button[i][j] = new prizeButton( "  P  " +  prizeLocation);		
					System.out.println("placed to" + prizeLocation);
					placed = true;
				}			
				if( ( (int) (firstBombLocation / 5) + 1 == i) && (firstBombLocation % 5 == j)) { //Row && Column first bomb
					button[i][j] = new bombButton( "  B  " + firstBombLocation );
					System.out.println("placed to" + firstBombLocation);
					placed = true;
				}			
				if( ( (int) (secondBombLocation / 5) + 1 == i) && (secondBombLocation % 5 == j)) { //Row && Column second bomb
					button[i][j] = new bombButton( "  B2 " + secondBombLocation);
					System.out.println("placed to" + secondBombLocation);
					placed = true;
				}			
				if( !placed ) {
				button[i][j] = new gameButton("    "  + (i * 5 +j) );
				}		
				panel.add(button[i][j]);
			}
		}

		panel.add(label);

	}

	/** Picks a random number from 1 to 25 //TODO ARRAYA DÖNDÜRT BUNU
	 * @return number
	 */
	private static int randomNumberGenerate() {
		int number;
		number = (int) (Math.random() * 25) + 1;
		return number;
	}
}
