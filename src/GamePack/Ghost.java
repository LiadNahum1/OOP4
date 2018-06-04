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
	public void move(Vector<String> [][] neighbors) {
		/*String dir;
		if(isScared) {
			dir= findsScaredMove(neighbors);
		}
		else {
			dir = findMoveDir(neighbors);
			this.currPosition = this.position.get(dir);
		}
		if(dir == "u")
		{
			dx = 0;
			dy =3;
		}
		if(dir == "d")
		{
			dx = 0;
			dy =-3;
		}
		if(dir == "l")
		{
			dx = 3;
			dy =0;
		}
		if(dir == "r")
		{
			dx = -3;
			dy = 0;
		}
		this.lastPos = dir;*/
	}

	private String findsScaredMove(Vector<String>[][] neighbors) {
		// TODO Auto-generated method stub
		return null;
	}

	private String findMoveDir(Vector<String> [][] neighbors) {
		Vector <String> posDirs =neighbors[this.boardTileIn.getX()][this.boardTileIn.getY()];

		/*if(posDirs.size()==2 & posDirs.contains(this.lastPos))
			return this.lastPos;
		else
			return bestNove(posDirs);*/
		return "";
	}

	private String bestNove(Vector<String> posDirs) { //this ghost try to ambush pacman from the sides
		if(this.chasePlace.getX() < this.boardTileIn.getX() & posDirs.contains("r"))
			return "r";
		if(this.chasePlace.getX() > this.boardTileIn.getX() & posDirs.contains("l"))
			return "l";
		if(this.chasePlace.getY() < this.boardTileIn.getY() & posDirs.contains("u"))
			return "u";
		if(this.chasePlace.getY() > this.boardTileIn.getY() & posDirs.contains("d"))
			return "d";
		else {
			return posDirs.get(0);
		}
	}public abstract void visit(NicePacman pacman);
	public abstract void visit(DefendedPacman pacman);
	public abstract void visit(AngryPacman pacman);

	public Pair getBoardTileIn() {
		return boardTileIn;
	}
	public void setBoardTileIn(Pair currentPosition) {
		this.boardTileIn = currentPosition;
	}

}
