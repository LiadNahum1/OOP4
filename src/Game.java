import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.RoundRectangle2D;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JFrame implements ActionListener, KeyListener {
	private BoardTile [][] boardTiles;
	private String [][] boardTilesS; 
	private Vector [][] pDirection; //possible directions
	private Timer timer;
	private int level; 
	private Pacman pacman;
	private boolean start; 


	public Game(int level) {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.level = level; 
		this.setBackground(Color.BLACK);
		this.setSize(800,800);
		this.start = true; 
		this.timer = new Timer(500, this);

		if(level == 1) {
			this.pacman = new NicePacman(new Pair(400,400)); 
		}
		this.addKeyListener(this);
		this.setVisible(true);
	}

	public void initializeBoardTilesS() {
		
		this.boardTilesS = new String[][] 
			 {{"w","w","w","w","w","w","w","w","w","w","w","w","w","w","w", "w","w","w","w","w","w","w","w","w","w","w","w","w","w","w","w","w"},
		      {"w", "d","d","d","d","d","d","d","d","d","d","d","d","d","d","w","w","d","d","d","d","d","d","d","d","d","d","d","d","d","d","w"},
		      {"w", "d","w","w","w","w","d","w","w","w","w","w","w","w","d","w","w","d","w","w","w","w","w","w","w","d","w","w","w","w","d","w"},
		      {"w", "d","w","w","w","w","d","w","w","w","w","w","w","w","d","w","w","d","w","w","w","w","w","w","w","d","w","w","w","w","d","w"},
		      {"w", "d","w","w","w","w","d","w","w","w","w","w","w","w","d","w","w","d","w","w","w","w","w","w","w","d","w","w","w","w","d","w"},
		      {"w", "d","w","w","w","w","d","w","w","w","w","w","w","w","d","w","w","d","w","w","w","w","w","w","w","d","w","w","w","w","d","w"},
		      {"w", "d","d","d","d","d","d","d","d","d","d","d","d","d","d","d","d","d","d","d","d","d","d","d","d","d","d","d","d","d","d","w"},
		      {"w", "d","w","w","w","w","d","w","d","w","w","w","w","w","w","w","w","w","w","w","w","w","w","d","w","d","w","w","w","w","d","w"},
		      {"w", "d","w","w","w","w","d","w","d","w","w","w","w","w","w","w","w","w","w","w","w","w","w","d","w","d","w","w","w","w","d","w"},
		      {"w", "d","d","d","d","d","d","w","d","d","d","d","d","d","d","w","w","d","d","d","d","d","d","d","w","d","w","w","w","w","d","w"},
		      {"w", "w","w","w","w","w","d","w","w","w","w","w","w","w","0","w","w","0","w","w","w","w","w","w","w","d","w","w","w","w","w","w"},
		      {"w", "w","w","w","w","w","d","w","w","w","w","w","w","w","0","w","w","0","w","w","w","w","w","w","w","d","w","w","w","w","w","w"},
		      {"w", "w","w","w","w","w","d","w","0","0","0","0","0","0","0","w","w","0","0","0","0","0","0","0","w","d","w","w","w","w","w","w"},
		      {"w", "w","w","w","w","w","d","w","0","w","w","w","w","w","0","w","w","0","w","w","w","w","w","0","w","d","w","w","w","w","w","w"},
		      {"w", "w","w","w","w","w","d","w","0","w","w","w","0","0","0","0","0","0","0","0","w","w","w","0","w","d","w","w","w","w","w","w"},
		      {"w", "w","w","w","w","w","d","0","0","w","w","w","0","w","w","g","g","w","w","0","w","w","w","0","w","0","w","w","w","w","w","w"},
		      {"w", "w","w","w","w","w","d","w","0","w","w","w","0","w","w","w","w","w","w","0","w","w","w","0","w","d","w","w","w","w","w","w"},
		      {"w", "w","w","w","w","w","d","w","0","w","w","w","0","0","0","0","0","0","0","0","w","w","w","0","w","d","w","w","w","w","w","w"},
		      {"w", "w","w","w","w","w","d","w","0","w","w","w","w","w","w","w","w","w","w","w","w","w","w","0","w","d","w","w","w","w","w","w"},
		      {"w", "w","w","w","w","w","d","w","0","w","w","w","w","w","w","w","w","w","w","w","w","w","w","0","w","d","w","w","w","w","w","w"},
		      {"w", "d","d","d","d","d","d","d","d","d","d","d","d","d","d","w","w","d","d","d","d","d","d","d","d","d","d","d","d","d","d","w"},
		      {"w", "d","w","w","w","w","d","w","w","w","w","w","w","w","d","w","w","d","w","w","w","w","w","w","w","d","w","w","w","w","d","w"},
		      {"w", "d","w","w","w","w","d","w","w","w","w","w","w","w","d","w","w","d","w","w","w","w","w","w","w","d","w","w","w","w","d","w"},
		      {"w", "d","d","d","w","w","d","d","d","d","d","d","d","d","d","w","w","d","d","d","d","d","d","d","d","d","w","w","d","d","d","w"},
		      {"w", "w","w","d","w","w","d","w","d","w","w","w","w","w","w","w","w","w","w","w","w","w","w","d","w","d","w","w","d","w","w","w"},
		      {"w", "d","d","d","w","w","d","w","d","d","d","d","d","d","d","w","w","d","d","d","d","d","d","d","w","d","w","w","d","d","d","w"},
		      {"w", "w","w","d","w","w","d","w","d","w","w","w","w","w","d","w","w","d","w","w","w","w","w","d","w","d","w","w","d","w","w","w"},
		      {"w", "d","d","d","d","d","d","w","d","d","d","d","d","d","d","w","w","d","d","d","d","d","d","d","w","d","d","d","d","d","d","w"},
		      {"w", "d","w","w","w","w","w","w","w","w","w","w","w","w","d","w","w","d","w","w","w","w","w","w","w","w","w","w","w","w","d","w"},
		      {"w", "d","w","w","w","w","w","w","w","w","w","w","w","w","d","w","w","d","w","w","w","w","w","w","w","w","w","w","w","w","d","w"},
		      {"w", "d","d","d","d","d","d","d","d","d","d","d","d","d","d","w","w","d","d","d","d","d","d","d","d","d","d","d","d","d","d","w"},
		      {"w","w","w","w","w","w","w","w","w","w","w","w","w","w","w","w","w","w","w","w","w","w","w","w","w","w","w","w","w","w","w","w"}};

	}
	private void initializeBoardTile(Graphics g) {
		Image offIm = createImage(getSize().width, getSize().height);
		Graphics offGr = offIm.getGraphics();

		offGr.setColor(Color.BLUE);
		int start = 50;
		int size = 800; 
		int arcWidth = 20;
		int arcHeight = 20; 
		Graphics2D graphics2 = (Graphics2D) offGr;
		graphics2.drawRoundRect(start-5, start-5, size, size, arcWidth, arcHeight);
		graphics2.drawRoundRect(start , start, size-10, size-10, arcWidth, arcHeight); //y = 50
		graphics2.setColor(Color.white);
		for(int i = start + 10; i< size; i = i + 20) {
			graphics2.fillOval(i, start + 10, 5, 5); //dots size is 5,5  y=75
		}
		graphics2.setColor(Color.BLUE);
		graphics2.drawRoundRect(start+ 25, start + 25, 4*25, 3*25, arcWidth, arcHeight);
		graphics2.drawRoundRect(start+ 6*25 , start + 25, 7*25,3*25, arcWidth, arcHeight); 
		int middle = size / 2 ; // end middle part 
		graphics2.drawRoundRect(start + 17*25 , start + 25, 7*25,3*25, arcWidth, arcHeight);
		graphics2.drawRoundRect(start + 25*25, start + 25, 4*25, 3*25, arcWidth, arcHeight);//y=150

		graphics2.drawRoundRect(start + 25, start + 5*25, 4*25, 25, arcWidth, arcHeight);//y=200
		graphics2.drawRoundRect(start + 25*6, start + 5*25, 25, 25*5, arcWidth, arcHeight);
		graphics2.drawRoundRect(start + 25*7, start + 7*25, 25*5, 25, arcWidth, arcHeight);

		graphics2.drawRoundRect(start + 25*8, start + 5*25, 14*25, 25, arcWidth, arcHeight);
		graphics2.drawRoundRect(start + 25*14, start + 6*25, 2*25, 25*4, arcWidth, arcHeight);

		graphics2.drawRoundRect(start + 25*25, start + 5*25, 4*25, 25, arcWidth, arcHeight);
		graphics2.drawRoundRect(start + 23*25, start + 5*25, 25, 25*5, arcWidth, arcHeight);
		graphics2.drawRoundRect(start + 18*25, start + 7*25, 25*5, 25, arcWidth, arcHeight);

		g.drawImage(offIm, 0, 0, this);


	}
	public void paint(Graphics g){
		if(this.start) {
			initializeBoardTile(g);
			start = false;
		}
		else {
			Image im = this.pacman.draw(this, g);
			Pair position = this.pacman.getCurrentPosition();
			g.drawImage(im,position.getX(), position.getY(), this);
		}
	}

	public static void main(String[]args) {
		new Game(1);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(this.timer)) {
			if(!this.start)
				this.pacman.move();
			repaint();
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			this.timer.start();
		}
		else {
			this.pacman.manageMovement(e);
			repaint();
		}

	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}



}  
