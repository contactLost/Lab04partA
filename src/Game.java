import java.awt.*;
import javax.swing.*;

/**		Pot Luck Design and implement a GUI application that presents a game based on a 5 by 5 matrix of buttons. 
 * One of the buttons (selected at random) "hides" the prize, while two of the buttons (selected at random, 
 * should be different than each other and prize button) hide bombs. A status bar at the top of the window 
 * shows the number of guesses. When the prize button is pressed, the status bar shows "You got it in x attempts!".
 * When one of the bomb buttons is pressed, the status bar shows "Sorry! You are blown up at attempt x!".
 * 
 * @author Tuna Dalbeler
 * @version LIVE 0.1
 */
public class Game extends JFrame {

	final int FRAME_WIDTH = 310;
	final int FRAME_HEIGHT = 350;

	private static Game game;
	private gameButton[][] button;
	private static JLabel label;
	private JPanel panel;
	private JPanel panel2;

	/**Game Constructor. Manages game frame.
	 * 
	 */
	public Game() {
		createComponents();

		setTitle("Game - ver LIVE 0.1");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		setLayout(new BorderLayout());
		add(panel, BorderLayout.NORTH);
		add(panel2, BorderLayout.CENTER);
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {

		game = new Game();

		while (true) {

			if (gameButton.isGameOver()) {
				if (gameButton.gameCondition == 1) {
					label.setText("You got it in " + gameButton.attempts + " attempts!");
				}
				if (gameButton.gameCondition == -1) {
					label.setText("Sorry! You are blown up at attempt " + gameButton.attempts + "!");
				}
			} else {
				label.setText("Attempts: " + gameButton.attempts);
			}
		}
	}

	/** Creates all components except frame
	 *	
	 */
	private void createComponents() {

		panel = new JPanel();
		label = new JLabel("Hello, World!" + gameButton.attempts);
		panel.add(label, BorderLayout.NORTH);

		panel2 = new JPanel();

		int prizeLocation = randomNumberGenerate();
		int firstBombLocation = randomNumberGenerate();
		while (prizeLocation == firstBombLocation) {
			firstBombLocation = randomNumberGenerate();
		}
		int secondBombLocation = randomNumberGenerate();
		while ((prizeLocation == secondBombLocation) || (firstBombLocation == secondBombLocation)) {
			secondBombLocation = randomNumberGenerate();
		}

		button = new gameButton[5][5];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {

				boolean placed = false;

				if ((((int) (prizeLocation / 5)) == i) && (prizeLocation % 5 == j)) { // Row && Column for prize
					button[i][j] = new prizeButton("     ");

					placed = true;
				}
				if ((((int) (firstBombLocation / 5)) == i) && (firstBombLocation % 5 == j)) { // Row && Column first
																								// bomb
					button[i][j] = new bombButton("     ");

					placed = true;
				}
				if ((((int) (secondBombLocation / 5)) == i) && (secondBombLocation % 5 == j)) { // Row && Column second
																								// bomb
					button[i][j] = new bombButton("     ");

					placed = true;
				}
				if (!placed) {
					button[i][j] = new gameButton("    ");
				}
				panel2.add(button[i][j], BorderLayout.CENTER);

			}

		}
		panel2.add(new restartButton("Restart"));
	}

	/**Picks a random number from 1 to 25
	 * 
	 * @return number
	 */
	private static int randomNumberGenerate() {
		int number;
		number = (int) (Math.random() * 25) + 1;
		return number;
	}

	/**Restarts the game
	 */
	static void restart() {
		game.setVisible(false);
		gameButton.gameCondition = 0;
		gameButton.attempts = 0;
		game = new Game();

	}

}
