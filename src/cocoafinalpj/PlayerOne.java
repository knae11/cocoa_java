package cocoafinalpj;

import java.awt.Graphics;
import java.awt.Image;

public class PlayerOne extends Character implements Runnable {

    private int playerX = Main.INIT_X;
    private int playerY = Main.INIT_Y;
    private boolean up, left, down, right, hit;


    private Image playerOne;
    private String pathname = "src/cocoafinalpj/image/fox/leftwalk1.png";

    public PlayerOne() {
        super();
        playerOne = makeCharacter(pathname);
    }


    public void keyProcess() {
        if (up && playerY - playerSpeed> 0) {
            playerY -= playerSpeed;
        }
        if(down && playerY +playerSpeed < Main.INIT_Y){
            playerY += playerSpeed;
        }
        if ( left && playerX - playerSpeed >0){
            playerX -= playerSpeed;
        }
        if( right && playerX + playerSpeed +Main.CHAR_WIDTH  < Main.BOARD_WIDTH/2 ){
            playerX += playerSpeed;
        }
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

    public void paint(Graphics g){
        playerOneDraw(g);
    }

    public void playerOneDraw(Graphics g){
        g.drawImage(playerOne, playerX, playerY, null);
    }

    @Override
    public void run() {
        while(true){
            try {
                keyProcess();
                System.out.println("thread 1 going");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
