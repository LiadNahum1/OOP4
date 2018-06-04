package GamePack;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.ImageIcon;

public class GreenGhost extends Ghost {
	public GreenGhost(Pair inisialPxIn, Pair packmanPosition,Pair inisialPositionTile,Vector<String> [][] neighbors) {
		super(inisialPxIn,packmanPosition , inisialPositionTile , 3 ,neighbors , "green");
	}



	@Override
	public void visit(NicePacman pacman) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(DefendedPacman pacman) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(AngryPacman pacman) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.TimeFromExit%5 == 0) {
			this.moveTile();
		}
		move();
		this.TimeFromExit++;
	}

}
