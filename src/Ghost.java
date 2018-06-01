import java.util.Vector;

public abstract class Ghost  implements Visitor {
	protected int curDir;
	private Pair currentPosition;
	protected Pair chasePlace;
	public Ghost(int x,int y ) {
		this.currentPosition = new Pair(x,y);
		this.curDir = 0;//up
	}
	public void collide(Pacman pacman) {
		pacman.impact(this);
	}
	public Pair move(String board [][]) {

	return null;	

	}
	
	public abstract void visit(NicePacman pacman);
	public abstract void visit(DefendedPacman pacman);
	public abstract void visit(AngryPacman pacman);

	public Pair getCurrentPosition() {
		return currentPosition;
	}
	public void setCurrentPosition(Pair currentPosition) {
		this.currentPosition = currentPosition;
	}

}
