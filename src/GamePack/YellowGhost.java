package GamePack;
import java.awt.Image;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.ImageIcon;

public class YellowGhost extends Ghost{
	private String lastPos;
	private Image currPosition;
	private HashMap <String,Image> position;
	private int dx;
	private int dy;
	private boolean isScared;
	public YellowGhost(Pair initialPosition) {
		super(initialPosition);
		this.chasePlace = new Pair(0,0);
		updateDirsPic();
		lastPos = "u";
		currPosition = position.get(lastPos);
	}

	private void updateDirsPic() { 
		position = new HashMap<String ,Image>();
		position.put("u", new ImageIcon("pictures/figures/yellow_u.png").getImage());
		position.put("l", new ImageIcon("pictures/figures/yellow_l.png").getImage());
		position.put("r", new ImageIcon("pictures/figures/yellow_r.png").getImage());
		position.put("d", new ImageIcon("pictures/figures/yellow_d.png").getImage());
		position.put("sceard", new ImageIcon("pictures/figures/scared.png").getImage());
	}

	@Override
	public void visit(NicePacman pacman) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(DefendedPacman pacman) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(AngryPacman pacman) {
		// TODO Auto-generated method stub

	}

	@Override
	public void move(Vector<String> [][] neighbors) {
		String dir;
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
			dy =1;
		}
		if(dir == "d")
		{
			dx = 0;
			dy =-1;
		}
		if(dir == "l")
		{
			dx = 1;
			dy =0;
		}
		if(dir == "r")
		{
			dx = -1;
			dy = 0;
		}
		this.lastPos = dir;
	}

	private String findsScaredMove(Vector<String>[][] neighbors) {

		Vector <String> posDirs =neighbors[this.boardTileIn.getX()][this.boardTileIn.getY()];
		if(this.chasePlace.getY() > this.boardTileIn.getY() & posDirs.contains("u"))
			return "u";
		if(this.chasePlace.getY() < this.boardTileIn.getY() & posDirs.contains("d"))
			return "d";
		if(this.chasePlace.getX() > this.boardTileIn.getX() & posDirs.contains("r"))
			return "r";
		if(this.chasePlace.getX() < this.boardTileIn.getX() & posDirs.contains("l"))
			return "l";

		else {
			return posDirs.get(0);
		}
	}

	private String findMoveDir(Vector<String> [][] neighbors) {
		Vector <String> posDirs =neighbors[this.boardTileIn.getX()][this.boardTileIn.getY()];

		if(posDirs.size()==2 & posDirs.contains(this.lastPos))
			return this.lastPos;
		else
			return bestNove(posDirs);
	}

	private String bestNove(Vector<String> posDirs) { //this ghost try to ambush pacman from the above/below
		if(this.chasePlace.getY() < this.boardTileIn.getY() & posDirs.contains("u"))
			return "u";
		if(this.chasePlace.getY() > this.boardTileIn.getY() & posDirs.contains("d"))
			return "d";
		if(this.chasePlace.getX() < this.boardTileIn.getX() & posDirs.contains("r"))
			return "r";
		if(this.chasePlace.getX() > this.boardTileIn.getX() & posDirs.contains("l"))
			return "l";

		else {
			return posDirs.get(0);
		}
	}

}
