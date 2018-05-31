import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class WallTile extends JLabel {
    private ImageIcon [] pictures;
public WallTile (int level){
    super();
    inisializePictures();
    this.setIcon(pictures[level-1]);
}
    private void inisializePictures() {
    pictures = new ImageIcon[3];
        pictures[0] = new ImageIcon("pictures/boards/level1wall.png");
        pictures[1] = new ImageIcon("pictures/boards/level2wall.png");
        pictures[2] = new ImageIcon("pictures/boards/level3wall.png");
    }
    public boolean isMovable(Object Obj){
        return false;
    }
}
