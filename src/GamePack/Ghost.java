package GamePack;
import java.util.Vector;

public abstract class Ghost  implements Visitor {
	protected Pair boardTileIn;
	protected Pair chasePlace;
	public Ghost(Pair inisialisPosition) {
		this.boardTileIn = inisialisPosition;
	}
	public void collide(Pacman pacman) {
		pacman.impact(this);
	}
	public abstract void move(Vector<String>[][] neighbors);
	public abstract void visit(NicePacman pacman);
	public abstract void visit(DefendedPacman pacman);
	public abstract void visit(AngryPacman pacman);

	public Pair getBoardTileIn() {
		return boardTileIn;
	}
	public void setBoardTileIn(Pair currentPosition) {
		this.boardTileIn = currentPosition;
	}

}
