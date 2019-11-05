import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class gameButton extends JButton{

	static int attempts = 0;
	static int gameCondition = 0;

	/**Writes the given string onto button
	 * @param string
	 */
	public gameButton(String name) {
		super(name);

		if( !(this instanceof prizeButton) && !(this instanceof bombButton) ) {
			ActionListener listener = new ClickListener();
			addActionListener( listener );
		}
	}

	public static boolean isGameOver() {
		if( gameCondition == 0) {
			return false;
		}
		else { //-1 or 1
			return true;
		}
	}

	public void increaseAttempts() {
		attempts++;
	}

	public class ClickListener implements ActionListener

	{
		public void actionPerformed(ActionEvent event)
		{
			if( isGameOver() == false) { //If game is not over execute
				System.out.println( "I was clicked.");
				increaseAttempts();
			}
		}
	}
}