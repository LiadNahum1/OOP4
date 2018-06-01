import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.RoundRectangle2D;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
//for liad: checkout my implimant of ghost movment and position i recomened that we will try to understand each other code so there wont be collitions and messy work :) ,<3
public class Game extends JFrame implements ActionListener, KeyListener {
	private String [][] boardTilesS; 
	private Vector <String> [][] pDirection; //possible directions
	private Image [] walls;
	private Image [] roads;
	private Image 
	gate;
	private Timer timer;
	private int level; 
	private Pacman pacman;
	private boolean start; 


	public Game(int level) {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.level = level; 
		this.setBackground(Color.BLACK);
		this.setLayout(new GridLayout(32,32));
		this.setSize(800,800);
		this.start = true; 
		this.timer = new Timer(500, this);
		if(level == 1) {
			this.pacman = new NicePacman(new Pair(400,400)); 
		}
		this.setBackground(Color.black);
		initializeBoardTilesS();
		initializeBoardTilesPic();
		repaint();
		this.addKeyListener(this);
		this.setVisible(true);
	}
	private void initializeBoardTilesPic() {
		walls = new Image [3];
		roads = new Image[5];
		this.walls[0] =  new ImageIcon("pictures/boards/level1wall.png").getImage();
		this.walls[1] = new ImageIcon("pictures/boards/level2wall.png").getImage();
		this.walls[2] = new ImageIcon("pictures/boards/level3wall.png").getImage();
		this.roads[0] =new ImageIcon("pictures/boards/Road.png").getImage();
		this.roads[1] = new ImageIcon("pictures/boards/energy.png").getImage();
		gate = new ImageIcon("pictures/boards/gate.png").getImage();
	}

	public static void main(String[]args) {
		new Game(3);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(this.timer)) {
			if(!this.start)
				this.pacman.move();
				//repaint();
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			this.timer.start();
		}
		else {
			this.pacman.manageMovement(e);
			//repaint();
		}

	}


	@Override
	public void keyReleased(KeyEvent argr) {
		// TODO Auto-generated method stub

	}


	@Override
	public void keyTyped(KeyEvent argr) {
		// TODO Auto-generated method stub

	}
	public void paint(Graphics g){
	if(this.start) {
      drawBoard(g);
		start = false;
	}
	else {
		Image im = this.pacman.draw(this, g);
		Pair position = this.pacman.getCurrentPosition();
		g.drawImage(im,position.getX(), position.getY(), this);
	}
}

	private void drawBoard(Graphics g) {
	for(int y=0; y<32;y++) {
		for(int x=0; x<32;x++) {
			if(boardTilesS [y][x] == "w") {
				g.drawImage(walls[level-1],x*25,(y+1)*25,this);
			}
				else if(boardTilesS [y][x] == "r")
					g.drawImage(roads[0],x*25,(y+1)*25,this);
				else if(boardTilesS [y][x] == "d" )
					g.drawImage(roads[1],x*25,(y+1)*25,this);
				else if(boardTilesS[y][x] == "g")
					g.drawImage(gate,x*25,(y+1)*25,this);	
			
			}
		}	
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
			{"w", "d","d","d","d","d","d","w","d","d","d","d","d","d","d","w","w","d","d","d","d","d","d","d","w","d","d","d","d","d","d","w"},
			{"w", "w","w","w","w","w","d","w","w","w","w","w","w","w","r","w","w","r","w","w","w","w","w","w","w","d","w","w","w","w","w","w"},
			{"w", "w","w","w","w","w","d","w","w","w","w","w","w","w","r","w","w","r","w","w","w","w","w","w","w","d","w","w","w","w","w","w"},
			{"w", "w","w","w","w","w","d","w","r","r","r","r","r","r","r","w","w","r","r","r","r","r","r","r","w","d","w","w","w","w","w","w"},
			{"w", "w","w","w","w","w","d","w","r","w","w","w","w","w","r","g","g","r","w","w","w","w","w","r","w","d","w","w","w","w","w","w"},
			{"w", "w","w","w","w","w","d","w","r","w","w","w","r","r","r","r","r","r","r","r","w","w","w","r","w","d","w","w","w","w","w","w"},
			{"w", "w","w","w","w","w","d","r","r","w","w","w","r","w","w","r","r","w","w","r","w","w","w","r","r","d","w","w","w","w","w","w"},
			{"w", "w","w","w","w","w","d","w","r","w","w","w","r","w","w","w","w","w","w","r","w","w","w","r","w","d","w","w","w","w","w","w"},
			{"w", "w","w","w","w","w","d","w","r","r","r","r","r","r","r","r","r","r","r","r","r","r","r","r","w","d","w","w","w","w","w","w"},
			{"w", "w","w","w","w","w","d","w","r","w","w","w","w","w","w","w","w","w","w","w","w","w","w","r","w","d","w","w","w","w","w","w"},
			{"w", "w","w","w","w","w","d","w","r","w","w","w","w","w","w","w","w","w","w","w","w","w","w","r","w","d","w","w","w","w","w","w"},
			{"w", "d","d","d","d","d","d","d","d","d","d","d","d","d","d","w","w","d","d","d","d","d","d","d","d","d","d","d","d","d","d","w"},
			{"w", "d","w","w","w","w","d","w","w","w","w","w","w","w","d","w","w","d","w","w","w","w","w","w","w","d","w","w","w","w","d","w"},
			{"w", "d","w","w","w","w","d","w","w","w","w","w","w","w","d","w","w","d","w","w","w","w","w","w","w","d","w","w","w","w","d","w"},
			{"w", "d","d","d","w","w","d","d","d","d","d","d","d","d","d","d","d","d","d","d","d","d","d","d","d","d","w","w","d","d","d","w"},
			{"w", "w","w","d","w","w","d","w","d","w","w","w","w","w","w","w","w","w","w","w","w","w","w","d","w","d","w","w","d","w","w","w"},
			{"w", "d","d","d","w","w","d","w","d","d","d","d","d","d","d","w","w","d","d","d","d","d","d","d","w","d","w","w","d","d","d","w"},
			{"w", "w","w","d","w","w","d","w","d","w","w","w","w","w","d","w","w","d","w","w","w","w","w","d","w","d","w","w","d","w","w","w"},
			{"w", "d","d","d","d","d","d","w","d","d","d","d","d","d","d","w","w","d","d","d","d","d","d","d","w","d","d","d","d","d","d","w"},
			{"w", "d","w","w","w","w","w","w","w","w","w","w","w","w","d","w","w","d","w","w","w","w","w","w","w","w","w","w","w","w","d","w"},
			{"w", "d","w","w","w","w","w","w","w","w","w","w","w","w","d","w","w","d","w","w","w","w","w","w","w","w","w","w","w","w","d","w"},
			{"w", "d","d","d","d","d","d","d","d","d","d","d","d","d","d","d","d","d","d","d","d","d","d","d","d","d","d","d","d","d","d","w"},
			{"w","w","w","w","w","w","w","w","w","w","w","w","w","w","w","w","w","w","w","w","w","w","w","w","w","w","w","w","w","w","w","w"}};
	}
	

}
