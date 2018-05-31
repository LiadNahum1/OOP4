import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;

public class Board extends JFrame implements ActionListener {
    private JLabel[][] boardTiles;
    private Vector[][] pDirection; //possible directions
    private Timer timer;
    private int level;
    private Pacman pacman;
    private String matrix [][];

    public Board(int level) {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(32,32));
        this.level = level;
        this.setBackground(Color.BLACK);
        this.setSize(1000, 1000);
        //initializeBoardTile();
        this.timer = new Timer(1000, this);
        this.boardTiles = new JLabel [5][5];
        if (level == 1) {
            this.pacman = new NicePacman(new Pair(400, 400));
            level1Board();
        }
        level1Board();//need to delete
        initializeBoard();
        this.timer.start();
        this.setVisible(true);
    }

    private void level1Board() {
        String matrix [][] ={{"w","g","g","g","r"}};
       this.matrix = matrix;
    }

    private void initializeBoard() {
        for(int i=0;i<4;i++){
            //for(int j=0;j<5;j++){
                initializeBoardTile(i,0);
                this.getContentPane().add(boardTiles[i][0]);
       // }
        }
    }


    private void initializeBoardTile (int x,int y) {
        if(matrix [x][y] == "w")
            boardTiles[x][y] =new WallTile(this.level);
        if(matrix [x][y] == "r")
            boardTiles[x][y] =new RoadTile();
        if(matrix[x][y] == "g")
            boardTiles [x][y] = new GateTile();
            }
/*        Image offIm = createImage(getSize().width, getSize().height);
        Graphics offGr = offIm.getGraphics();

        offGr.setColor(Color.BLUE);
        int start = 50;
        int size = 800;
        int arcWidth = 20;
        int arcHeight = 20;
        Graphics2D graphics2 = (Graphics2D) offGr;
        graphics2.drawRoundRect(start - 5, start - 5, size, size, arcWidth, arcHeight);
        graphics2.drawRoundRect(start, start, size - 10, size - 10, arcWidth, arcHeight); //y = 50
        graphics2.setColor(Color.white);
        for (int i = start + 10; i < size; i = i + 20) {
            graphics2.fillOval(i, start + 10, 5, 5); //dots size is 5,5  y=75
        }
        graphics2.setColor(Color.BLUE);
        graphics2.drawRoundRect(start + 25, start + 25, 4 * 25, 3 * 25, arcWidth, arcHeight);
        graphics2.drawRoundRect(start + 6 * 25, start + 25, 7 * 25, 3 * 25, arcWidth, arcHeight);
        int middle = size / 2; // end middle part
        graphics2.drawRoundRect(start + 17 * 25, start + 25, 7 * 25, 3 * 25, arcWidth, arcHeight);
        graphics2.drawRoundRect(start + 25 * 25, start + 25, 4 * 25, 3 * 25, arcWidth, arcHeight);//y=150

        graphics2.drawRoundRect(start + 25, start + 5 * 25, 4 * 25, 25, arcWidth, arcHeight);//y=200
        graphics2.drawRoundRect(start + 25 * 6, start + 5 * 25, 25, 25 * 5, arcWidth, arcHeight);
        graphics2.drawRoundRect(start + 25 * 7, start + 7 * 25, 25 * 5, 25, arcWidth, arcHeight);

        graphics2.drawRoundRect(start + 25 * 8, start + 5 * 25, 14 * 25, 25, arcWidth, arcHeight);
        graphics2.drawRoundRect(start + 25 * 14, start + 6 * 25, 2 * 25, 25 * 4, arcWidth, arcHeight);

        graphics2.drawRoundRect(start + 25 * 25, start + 5 * 25, 4 * 25, 25, arcWidth, arcHeight);
        graphics2.drawRoundRect(start + 23 * 25, start + 5 * 25, 25, 25 * 5, arcWidth, arcHeight);
        graphics2.drawRoundRect(start + 18 * 25, start + 7 * 25, 25 * 5, 25, arcWidth, arcHeight);

        this.getGraphics().drawImage(offIm, 0, 0, this);
*/
    

    public void paint(Graphics g) {
        Image offIm = createImage(getSize().width, getSize().height);
        Graphics offGr = offIm.getGraphics();
        ImageIcon im = new ImageIcon("C:\\Users\\����\\eclipse-workspace\\Pacman\\src\\pictures\\figures\\NicePacman\\left.png");
        System.out.println(offGr.drawImage(im.getImage(), 150, 150, im.getImageObserver()));
        g.drawImage(offIm, 0, 0, this);
    }

    public static void main(String[] args) {
        new Board(2);
        //dfgkjfd
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.timer)) {
            this.pacman.move();
            repaint();
        }
    }

}
