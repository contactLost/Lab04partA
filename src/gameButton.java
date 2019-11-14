import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/** This class creates normal buttons. Which means
 * these buttons are not bomb or prize.
 * @author Tuna Dalbeler
 *
 */
public class gameButton extends JButton{

	//Properties
	static int attempts = 0;
	static int gameCondition = 0;
	boolean clicked;

	//Constructor
	
	/**Writes the given string onto button
	 * @param name
	 */
	public gameButton(String name) {
		super(name);
		
		if( !(this instanceof prizeButton) && !(this instanceof bombButton) ) {
			ActionListener listener = new ClickListener();
			addActionListener( listener );
		}
		
		clicked = false;
	}

	//Additional methods
	
	/**Checks whether game is over
	 * 
	 * @return true if game is over
	 * @return false if game is continuing 
	 */
	public static boolean isGameOver() {
		if( gameCondition == 0) {
			return false;
		}
		else { //-1 or 1
			return true;
		}
	}

	/**Increases user attempt by 1
	 * 
	 */
	public void increaseAttempts() {
		attempts++;
	}
	
	/**If a button is clicked sets to clicked
	 * 
	 */
	public void setClicked() {
		clicked = true;
	}
	
	/**Returns the clicked status
	 * @return
	 */
	public boolean getClicked() {
		return clicked;
	}

	/**This class listens normal buttons.
	 * Increases attempt counter and sets clicked status.
	 * @author Tuna Dalbeler
	 */
	public class ClickListener implements ActionListener

	{
		public void actionPerformed(ActionEvent event)
		{
			if( isGameOver() == false) { //If game is not over execute
				System.out.println( "I was clicked.");
				if( !getClicked() ) {
					increaseAttempts();
				}
				setText("  *  ");
				setClicked();
			}
		}
	}
}
