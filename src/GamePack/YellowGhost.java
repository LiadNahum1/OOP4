package GamePack;
import java.awt.event.ActionEvent;
import java.util.Vector;

public class YellowGhost extends Ghost{
	public YellowGhost(Pair pxIn, Pair chasePlace, Pair boardTileIn, Vector<String>[][] neighbors) {
		super(pxIn, chasePlace, boardTileIn, 1, neighbors, "yellow");
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
