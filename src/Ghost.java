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
		Vector <Pair> possibleDirs = getPosDirs(board);
		if(possibleDirs.size()==1) {
			return possibleDirs.get(0);
		}
		else {
	//	int	i = calculateMovesToCatch(currentPosition,possibleDirs);
		}
	return null;	

	}

	
			
			
	
	private Vector<Pair> getPosDirs(String[][] board) {
		Vector <Pair> possibleDirs = new Vector <>();
		int curX = currentPosition.getX()/25;
		int curY = currentPosition.getX()/25;
		if(board[curY+1][curX]!="w"& curDir!=1) //can move up
			possibleDirs.add(new Pair(curX,curY+1));
		if(board[curY-1][curX]!="w"& curDir!=0)//can move down
			possibleDirs.add(new Pair(curX,curY-1));
		if(board[curY][curX+1]!="w"& curDir!=2)//can move right
			possibleDirs.add(new Pair(curX+1,curY));
		if(board[curY][curX-1]!="w"& curDir!=3)//can move left
			possibleDirs.add(new Pair(curX-1,curY));
		return possibleDirs;
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
