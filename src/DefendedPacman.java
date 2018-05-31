import javax.swing.ImageIcon;

public class DefendedPacman extends Pacman {
	private ImageIcon [] pacmanIcons;
	
	public DefendedPacman() {
		this.pacmanIcons = new ImageIcon[5];
		this.pacmanIcons[0] = new ImageIcon("pictures\\figures\\DefendedPacman\\left.png");
		this.pacmanIcons[1] = new ImageIcon("pictures\\figures\\DefendedPacman\\right.png");
		this.pacmanIcons[2] = new ImageIcon("pictures\\figures\\DefendedPacman\\up.png");
		this.pacmanIcons[3] = new ImageIcon("pictures\\figures\\DefendedPacman\\down.png");
		this.pacmanIcons[4] = new ImageIcon("pictures\\figures\\DefendedPacman\\fullPacman.png");
	}
	@Override
	public void impact(Visitor v) {
	v.visit(this);
	}
}
