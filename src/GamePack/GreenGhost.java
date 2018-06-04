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

	

}
