import javax.swing.ImageIcon;

public class DotTile extends BoardTile {
	 private boolean isEaten;
	    public DotTile() {
	        super();
	        
	        this.setIcon(new ImageIcon("pictures/boards/energy.png"));
	    }

	    public void setEaten() {
	        if (!isEaten) {
	            this.setIcon(new ImageIcon("pictures/boards/energy.png"));
	            this.isEaten = true;
	        }
	    }

	    public boolean isMovable(Object Obj){
	        return false;
	    }
}
