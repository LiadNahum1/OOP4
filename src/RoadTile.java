import javax.swing.*;

public class RoadTile extends JLabel {
    private boolean isEaten;
    public RoadTile() {
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

