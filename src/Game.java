import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.*;

//SEARCH AND USE GRID LAYOUT - AYNUR RECOMENDS


public class Game extends JFrame{

	final int FRAME_WIDTH = 310;
	final int FRAME_HEIGHT = 350; 

	private static Game game;
	private gameButton[][] button;
	private static JLabel label;
	private static JFrame frame;
	private JPanel panel;
	private JPanel panel2;

	public Game() {
		createComponents();

		setTitle( "Game - ver BETA build 0.1");
		setSize( FRAME_WIDTH, FRAME_HEIGHT); 
		setResizable(false);
		setLayout( new BorderLayout() );
		//		panel.setLayout( new BorderLayout() );
		//		panel2.setLayout( new BorderLayout() );
		add( panel ,BorderLayout.NORTH);
		add( panel2, BorderLayout.CENTER);
		setVisible( true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

	}

	public static void main( String[] args ) {

		game = new Game();	

		while(true) {

			if( gameButton.isGameOver() ) {
				if(gameButton.gameCondition == 1) {
					label.setText( "You got it in " + gameButton.attempts + " attempts!" );
				}
				if(gameButton.gameCondition == -1) {
					label.setText( "Sorry! You are blown up at attempt " + gameButton.attempts + "!" );
				}
			}
			else{
				label.setText("Attempts: " + gameButton.attempts );
			}
		}
	}



	private void createComponents() {

		panel = new JPanel();
		label = new JLabel( "Hello, World!" + gameButton.attempts );
		panel.add( label , BorderLayout.NORTH);

		panel2 = new JPanel();

		int prizeLocation = randomNumberGenerate();
		int firstBombLocation = randomNumberGenerate();
		while(prizeLocation == firstBombLocation) { firstBombLocation = randomNumberGenerate(); }
		int secondBombLocation = randomNumberGenerate();
		while((prizeLocation == secondBombLocation) || (firstBombLocation == secondBombLocation) ) { secondBombLocation = randomNumberGenerate(); }


		button = new gameButton[5][5];



		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {

				boolean placed = false;

				if( ( ((int) ( prizeLocation / 5 ))  == i) && ( prizeLocation % 5 == j )) { //Row && Column for prize
					button[i][j] = new prizeButton( "     " );		

					placed = true;
				}			
				if( ( ((int) ( firstBombLocation / 5 ))  == i) && ( firstBombLocation % 5 == j )) { //Row && Column first bomb
					button[i][j] = new bombButton( "     "  );

					placed = true;
				}			
				if( (( (int) ( secondBombLocation / 5 ))  == i) && ( secondBombLocation % 5 == j )) { //Row && Column second bomb
					button[i][j] = new bombButton( "     " );

					placed = true;
				}			
				if( !placed ) {
					button[i][j] = new gameButton( "    "  );
				}		
				panel2.add( button[i][j] , BorderLayout.CENTER);
				
				
			}
			
		}
		panel2.add( new restartButton("Restart") );
	}

	/** Picks a random number from 1 to 25 
	 * @return number
	 */
	private static int randomNumberGenerate() {
		int number;
		number = (int) (Math.random() * 25) + 1;
		return number;
	}

	static void restart() {
		
		game = new Game();
		

	}
	
}


