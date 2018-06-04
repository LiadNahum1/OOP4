package GamePack;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.ImageIcon;

public class RedGhost extends Ghost {
		public RedGhost(Pair inisialPxIn, Pair packmanPosition,Pair inisialPositionTile,Vector<String> [][] neighbors) {
			super(inisialPxIn,packmanPosition , inisialPositionTile , 1 ,neighbors , "red");
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
