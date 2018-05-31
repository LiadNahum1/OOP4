import javax.swing.*;

public class GateTile extends BoardTile {
    public GateTile (){
        super();
        this.setIcon(new ImageIcon("pictures/boards/gate.png"));
    }
    public boolean isMovable(Pacman pac){
        return false;
    }
    public boolean isMovable(Ghost ghost){
        return true;
    }
}
