import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class restartButton extends JButton {
	public restartButton(String name) {
		super(name);

		ActionListener listener = new ClickListener();
		addActionListener( listener );

	}

	public class ClickListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event)
		{
			Game.restart();
		}
	}
}

