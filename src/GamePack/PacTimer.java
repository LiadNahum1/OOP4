package GamePack;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class PacTimer implements ActionListener {
	private Timer gameTimer; // main timer of the game 
	private Timer pacmanTimer; // timer that responsible for the movement of pacman
	private Timer fruitTimer;
	private int numTicksOfGame;
	private int numTicksOfFruit; 
	
	public PacTimer(ActionListener game) {
		this.gameTimer = new Timer(1000, game);
		this.gameTimer.addActionListener(this);
		this.pacmanTimer = new Timer(50, game);
		this.fruitTimer = new Timer(500, game);
		this.fruitTimer.addActionListener(this);
		this.numTicksOfGame = 0; 
		this.numTicksOfFruit = 0;
		
	}

	public Timer getGameTimer() {
		return this.gameTimer;
	}
	public Timer getPacmanTimer() {
		return this.pacmanTimer;
	}
	public Timer getFruitTimer() {
		return this.fruitTimer;
	}
	
	public int getNumTicksFruit() {
		return this.numTicksOfFruit;
	}
	public int getNumTicksGame() {
		return this.numTicksOfGame;
	}
	public void start() {
		this.gameTimer.start();
		this.pacmanTimer.start();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(this.gameTimer)) {
			this.numTicksOfGame = this.numTicksOfGame + 1;
			checkNumTicks();
		}		
		if(e.getSource().equals(this.fruitTimer)) {
			this.numTicksOfFruit = this.numTicksOfFruit + 1;
			checkNumTicks();
		}		
	}
	
	public void checkNumTicks() {
		if(this.numTicksOfGame == 10) {
			this.fruitTimer.start();
		}
		if(this.numTicksOfFruit == 11) {
			this.numTicksOfFruit = 0;
		}
	}
}
