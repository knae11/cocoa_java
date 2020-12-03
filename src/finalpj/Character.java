package finalpj;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class Character {

    final String path = "src/finalpj/image/character/";
    int playerSpeed = 5;
    boolean up, left, down, right;

    Character() {
    }

    Image makeCharacter(String pathname) {
        return new ImageIcon(pathname).getImage();
    }

    void setUp(boolean up) {
        this.up = up;
    }

    void setDown(boolean down) {
        this.down = down;
    }

    void setLeft(boolean left) {
        this.left = left;
    }

    void setRight(boolean right) {
        this.right = right;
    }

    abstract void keyProcess();

    abstract void playerDraw(Graphics g);

    abstract int getPlayerX();

    abstract int getPlayerY();

    abstract Image getWinner(int i);

    abstract Image getLoser(int i);

}
