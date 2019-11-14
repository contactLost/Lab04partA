import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**This class creates the prize button.
 * @author Tuna Dalbeler
 *
 */
public class prizeButton extends gameButton{

	/**Constuctor for prize button.
	 * @param label
	 */
	public prizeButton(String label) {
		super(label);
		ActionListener listener = new ClickListener();
		addActionListener( listener );
	}

	/**Sets game status. Win(1) - Cont.(0) - Defeat(-1)
	 * 
	 */
	public void setGameCondition() {
		gameCondition = 1;
	}

	/**Increases user attempt counter
	 * 
	 */
	public void increaseAttempts() {
		attempts++;
	}

	/**This class listens the prize button
	 * Sets game status if pressed.
	 * @author Tuna Dalbeler
	 *
	 */
	public class ClickListener extends gameButton.ClickListener{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			if( isGameOver() == false) { //If game is not over execute
				System.out.println( " I am prize.");
				increaseAttempts();
				setGameCondition();
			}
		}
	}
}
