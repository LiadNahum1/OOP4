import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class NicePacman extends Pacman{
	private ImageIcon [] pacmanIcons;
	private ImageIcon currentIcon;
	private ImageIcon fullPac; 
	private Pair currentPosition;
	private int dx;
	private int dy; 
	private boolean isFull;
	
	public NicePacman(Pair initialPosition) {
		this.pacmanIcons = new ImageIcon[5];
		this.pacmanIcons[0] = new ImageIcon("pictures\\figures\\NicePacman\\left.png");
		this.pacmanIcons[1] = new ImageIcon("pictures\\figures\\NicePacman\\right.png");
		this.pacmanIcons[2] = new ImageIcon("pictures\\figures\\NicePacman\\up.png");
		this.pacmanIcons[3] = new ImageIcon("pictures\\figures\\NicePacman\\down.png");
		this.fullPac = new ImageIcon("pictures\\figures\\NicePacman\\fullPac.png");
		this.currentPosition = initialPosition;
		this.currentIcon = this.pacmanIcons[0];
		this.dx = -5;
		this.dy = 0; 
		this.isFull = false; 

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
	public void manageMovement(KeyEvent e) {
		if(e.getKeyCode()== KeyEvent.VK_LEFT) {
			this.dx = -5;
			this.dy= 0;
			this.currentIcon = this.pacmanIcons[0];
		}
		if(e.getKeyCode()== KeyEvent.VK_RIGHT) {
			this.dx = 5;
			this.dy= 0;
			this.currentIcon = this.pacmanIcons[1];
		}
		if(e.getKeyCode()== KeyEvent.VK_UP) {
			this.dx = 0;
			this.dy= -5;
			this.currentIcon = this.pacmanIcons[2];
		}
		if(e.getKeyCode()== KeyEvent.VK_DOWN) {
			this.dx = 0;
			this.dy= 5;
			this.currentIcon = this.pacmanIcons[3];
		}
		move();
	}
	
	@Override
	public Image draw(Game game, Graphics g) {
		ImageIcon im;
		if(!isFull) {
			im = getCurrentIcon();
			this.isFull = true; 
		}
		else {
			im = this.fullPac;
			this.isFull = false;
		}
		Pair position = getCurrentPosition();
		g.fillRect(position.getX() -this.dx, position.getY() - this.dy, 25 ,25 ); // erase the previous image 
		Image offIm = game.createImage(25 , 25);
		Graphics offGr = offIm.getGraphics();	
		offGr.drawImage(im.getImage(), 0,0, game);
		g.setColor(Color.black);
		return offIm; 
	}
}
