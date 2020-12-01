package cocoafinalpj;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class Character {

    private Image character;

    public int playerSpeed = 30;
    public boolean up, left, down, right, hit;

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

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    abstract void keyProcess();
    abstract void playerDraw(Graphics g);
}