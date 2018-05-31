import java.awt.Component;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class NicePacman extends Pacman{
	private ImageIcon [] pacmanIcons;
	private ImageIcon currentIcon;
	private Pair currentPosition;
	private int dx;
	private int dy; 
	private Graphics componentG; 
	
	public NicePacman(Pair initialPosition) {
		this.pacmanIcons = new ImageIcon[5];
		this.pacmanIcons[0] = new ImageIcon("pictures\\figures\\NicePacman\\left.png");
		this.pacmanIcons[1] = new ImageIcon("pictures\\figures\\NicePacman\\right.png");
		this.pacmanIcons[2] = new ImageIcon("pictures\\figures\\NicePacman\\up.png");
		this.pacmanIcons[3] = new ImageIcon("pictures\\figures\\NicePacman\\down.png");
		this.pacmanIcons[4] = new ImageIcon("pictures\\figures\\NicePacman\\fullPacman.png");
		this.currentPosition = initialPosition;
		this.currentIcon = this.pacmanIcons[0];
		this.dx = -1;
		this.dy = 0; 

	}
	@Override
	public void impact(Visitor v) {
		v.visit(this);
		}
	
	public void move() {
		this.currentPosition.setX(this.dx);
		this.currentPosition.setY(this.dy);
	}
	
	public ImageIcon getCurrentIcon() {
		return this.currentIcon;
	}
	
	public Pair getCurrentPosition() {
		return this.currentPosition;
	}
	public void draw(Component c, Graphics g) {
		this.currentIcon.paintIcon(c, g, this.currentPosition.getX(), this.currentPosition.getY());
	}

}
