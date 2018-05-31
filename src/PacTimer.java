import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class PacTimer implements ActionListener {
	private Timer timer;
	private int timeSinceStart;
	
	public PacTimer() {
		this.timer = new Timer(500, this);
		this.timeSinceStart = 0;
		this.timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(this.timer)) {
			this.timeSinceStart = this.timeSinceStart +1;
		    new ActionEvent(e, this.timeSinceStart, null);
		}
		
	}
}  
