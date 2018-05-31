import javax.swing.ImageIcon;

public class AngryPacman extends Pacman {
	private ImageIcon [] pacmanIcons;
	
	public AngryPacman() {
		this.pacmanIcons = new ImageIcon[5];
		this.pacmanIcons[0] = new ImageIcon("pictures\\figures\\AngryPacman\\left.png");
		this.pacmanIcons[1] = new ImageIcon("pictures\\figures\\AngryPacman\\right.png");
		this.pacmanIcons[2] = new ImageIcon("pictures\\figures\\AngryPacman\\up.png");
		this.pacmanIcons[3] = new ImageIcon("pictures\\figures\\AngryPacman\\down.png");
		this.pacmanIcons[4] = new ImageIcon("pictures\\figures\\AngryPacman\\fullPacman.png");
	}
	@Override
	public void impact(Visitor v) {
		v.visit(this);
		}
}
