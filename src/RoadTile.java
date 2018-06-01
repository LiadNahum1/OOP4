import java.awt.Color;

import javax.swing.*;

public class RoadTile extends BoardTile {
	private boolean isEaten;
	public RoadTile(boolean isEaten) {
		super();
		if(isEaten) {
			isEaten = true;
			this.setIcon(new ImageIcon("pictures/boards/Road.png"));
		}
		else {
			isEaten =false;
			this.setIcon(new ImageIcon("pictures/boards/energy.png"));

		}
	}
}

