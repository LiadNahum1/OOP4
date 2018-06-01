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
		this.setLayout(new GridLayout(32,32));
		this.setSize(800,800);
		this.start = true; 
		this.timer = new Timer(500, this);
		if(level == 1) {
			this.pacman = new NicePacman(new Pair(400,400)); 
		}
		initializeBoardTilesS();
		initializeBoard();
		this.addKeyListener(this);
		this.setVisible(true);
	}
	private void initializeBoard() {
		this.boardTiles = new BoardTile [32][32];  
		for(int i=0;i<32;i++){
			for(int j=0;j<32;j++){
				initializeBoardTile(i,j);
				Container cp = this.getContentPane();
				cp.add(boardTiles[i][j]);
			}
		}
	}



		private void initializeBoardTile (int x,int y) {
			System.out.println(boardTilesS.length);
			if(boardTilesS [x][y] == "w")
				boardTiles[x][y] =new WallTile(this.level);
			if(boardTilesS [x][y] == "r")
				boardTiles[x][y] =new RoadTile();
			 if(boardTilesS [x][y] == "d" )
				 boardTiles[x][y] = new DotTile();
			if(boardTilesS[x][y] == "g")
				boardTiles [x][y] = new GateTile();
			
		}

				public static void main(String[]args) {
			new Game(1);
		}


		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(this.timer)) {
				if(!this.start)
					this.pacman.move();
			//	repaint();
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
				{"w", "d","d","d","d","d","d","w","d","d","d","d","d","d","d","w","w","d","d","d","d","d","d","d","w","d","d","d","d","d","d","w"},//
				{"w", "w","w","w","w","w","d","w","w","w","w","w","w","w","r","w","w","r","w","w","w","w","w","w","w","d","w","w","w","w","w","w"},
				{"w", "w","w","w","w","w","d","w","w","w","w","w","w","w","r","w","w","r","w","w","w","w","w","w","w","d","w","w","w","w","w","w"},
				{"w", "w","w","w","w","w","d","w","r","r","r","r","r","r","r","w","w","r","r","r","r","r","r","r","w","d","w","w","w","w","w","w"},
				{"w", "w","w","w","w","w","d","w","r","w","w","w","w","w","r","w","w","r","w","w","w","w","w","r","w","d","w","w","w","w","w","w"},
				{"w", "w","w","w","w","w","d","w","r","w","w","w","r","r","r","r","r","r","r","r","w","w","w","r","w","d","w","w","w","w","w","w"},
				{"w", "w","w","w","w","w","d","r","r","w","w","w","r","w","w","g","g","w","w","r","w","w","w","r","r","d","w","w","w","w","w","w"},
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
		
	
	/*public void paint(Graphics g){
		if(this.start) {
			//initializeBoardTile(g);
			start = false;
		}
		else {
			Image im = this.pacman.draw(this, g);
			Pair position = this.pacman.getCurrentPosition();
			g.drawImage(im,position.getX(), position.getY(), this);
		}
	}*/
		 



	}
