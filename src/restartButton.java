import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**Creates the restart button
 * Restarts the game if pressed
 * @author Tuna Dalbeler
 */
public class restartButton extends JButton {
	
	/**Constructor for restart button
	 * @param name
	 */
	public restartButton(String name) {
		super(name);

		ActionListener listener = new ClickListener();
		addActionListener( listener );

	}

	/**This class listens the restart button and restarts the game.
	 * @author tunad
	 */
	public class ClickListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event)
		{
			Game.restart();
		}
	}
}

