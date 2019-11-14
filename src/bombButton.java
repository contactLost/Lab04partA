import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**This class create bomb buttons
 * @author tunad
 *
 */
public class bombButton extends gameButton {

	/** Constructor for bomb buttons
	 * 
	 */
	public bombButton(String string) {
		super(string);
		ActionListener listener = new ClickListener();
		addActionListener( listener );
	}

	/**Sets game condition to defeat(-1)
	 * 
	 */
	public void setGameCondition() {
		gameCondition = -1;
	}

	/**Increases user attempt counter
	 * 
	 */
	public void increaseAttempts() {
		attempts++;
	}
	
	/**This class listens the bomb buttons
	 * Sets game status to defeat if pressed.
	 * @author tunad
	 *
	 */
	public class ClickListener extends gameButton.ClickListener{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			if( isGameOver() == false) { //If game is not over execute
				System.out.println( " I am bomb.");
				increaseAttempts();
				setGameCondition();
			}
		}
	}

}
