package cocoafinalpj;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class Character implements Runnable {

    private Image character;
    private int playerX;
    private int playerY;

    public int playerSpeed = 30;
    public boolean up, left, down, right, hit;

    public Character() {
    }

    public Image makeCharacter(String pathname) {
        character = new ImageIcon(pathname).getImage();
        return character;
    }

    public int getPlayerX() {
        return playerX;
    }

    public int getPlayerY() {
        return playerY;
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

    @Override
    public void run() {
        while (true) {
            try {
                keyProcess();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    abstract void keyProcess();

    abstract void playerDraw(Graphics g);
}
