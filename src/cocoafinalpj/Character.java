package cocoafinalpj;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class Character {

    private Image character;
    public final String path = "src/cocoafinalpj/image/character/";
    public int playerSpeed = 5;
    public boolean up, left, down, right;

    public Character() {
    }

    public Image makeCharacter(String pathname) {
        character = new ImageIcon(pathname).getImage();
        return character;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setRight(boolean right) {
        this.right = right;
    }


//    @Override
//    public void run() {
//        while (true) {
//            try {
//                keyProcess();
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//                return;
//            }
//        }
//    }

    abstract void keyProcess();

    abstract void playerDraw(Graphics g);

    abstract int getPlayerX();

    abstract int getPlayerY();

    //abstract ArrayList<Image> getWinner();

   // abstract  ArrayList<Image> getLoser();

}
