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
	public void move(String board [][]) {
		Vector <Integer> posibleDirs = getPosDirs(board);


	}

	private Vector<Integer> getPosDirs(String[][] board) {
		Vector <Integer> posibleDirs = new Vector <>();
		int curX = currentPosition.getX()/25;
		int curY = currentPosition.getX()/25;
		if(board[curY+1][curX]!="w"& curDir!=1) //can move up
			posibleDirs.add(0);
		if(board[curY-1][curX]!="w"& curDir!=0)//can move down
			posibleDirs.add(1);
		if(board[curY][curX+1]!="w"& curDir!=2)//can move right
			posibleDirs.add(3);
		if(board[curY][curX-1]!="w"& curDir!=3)//can move left
			posibleDirs.add(2);
		return posibleDirs;
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
