package GamePack;
import java.awt.Image;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.ImageIcon;

public class GreenGhost extends Ghost {
	private String lastPos;
	private Image currPosition;
	private HashMap <String,Image> position;
	private int dx;
	private int dy;
	private boolean isScared;
	public GreenGhost(Pair initialPosition) {
		super(initialPosition);
		this.chasePlace = new Pair(0,0);
	updateDirsPic();
	lastPos = "u";
	currPosition = position.get(lastPos);
	}

	private void updateDirsPic() { 
		position = new HashMap<String ,Image>();
	position.put("u", new ImageIcon("pictures/figures/green_u.png").getImage());
	position.put("l", new ImageIcon("pictures/figures/green_l.png").getImage());
	position.put("r", new ImageIcon("pictures/figures/green_r.png").getImage());
	position.put("d", new ImageIcon("pictures/figures/green_d.png").getImage());
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
		this.lastPos = dir;
	}

	private String findsScaredMove(Vector<String>[][] neighbors) {
		// TODO Auto-generated method stub
		return null;
	}

	private String findMoveDir(Vector<String> [][] neighbors) {
		Vector <String> posDirs =neighbors[this.boardTileIn.getX()][this.boardTileIn.getY()];
		
		if(posDirs.size()==2 & posDirs.contains(this.lastPos))
			return this.lastPos;
		else
			return bestNove(posDirs);
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
	}
}
