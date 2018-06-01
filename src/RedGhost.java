import java.awt.Image;

import javax.swing.ImageIcon;

public class RedGhost extends Ghost {
	private Image currPosition;
	private Image [] position;
	public RedGhost(int x, int y) {
		super(0, 0);
		this.chasePlace = new Pair(31,31);
	updateDirsPic();
	currPosition = position[0];
	}
	private void updateDirsPic() { //0 - up ,1 - down ,2 - left ,3 -right ,4 - scared
		position = new Image [4];
		position[0] = new ImageIcon("pictures/figures/red_u.png").getImage();
		position[1]= new ImageIcon("pictures/figures/red_d.png").getImage();
		position[2]= new ImageIcon("pictures/figures/red_l.png").getImage();
		position[3]= new ImageIcon("pictures/figures/red_r.png").getImage();
		position[4]= new ImageIcon("pictures/figures/scared.png").getImage();
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
	public void move(String[][] dirs) {
		// TODO Auto-generated method stub
		
	}

}
