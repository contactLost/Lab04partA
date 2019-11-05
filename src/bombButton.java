import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bombButton extends gameButton {


	public bombButton(String string) {
		super(string);
		ActionListener listener = new ClickListener();
		addActionListener( listener );
	}


	public void setGameCondition() {
		gameCondition = -1;
	}

	public void increaseAttempts() {
		attempts++;
	}

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
