package Tiles;
import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class BoardTile {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ImageIcon imageIcon; 
	
	public Image getImage() {
		return imageIcon.getImage();
	}
}
