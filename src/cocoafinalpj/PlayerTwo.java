package cocoafinalpj;

import java.awt.Graphics;
import java.awt.Image;

public class PlayerTwo extends Character implements Runnable {


    private int playerX = Main.BOARD_WIDTH-(Main.INIT_X+Main.CHAR_WIDTH);
    private int playerY = Main.INIT_Y;

    private boolean up, left, down, right, hit;

    private Image playerTwo;
    private String pathname = "src/cocoafinalpj/image/fox/rightwalk1.png";
    public PlayerTwo(){
        super();
        playerTwo = makeCharacter(pathname);

    }

    public void keyProcess() {
        if (up && playerY - playerSpeed> 0) {
            playerY -= playerSpeed;
        }
        if(down && playerY +playerSpeed < Main.INIT_Y){
            playerY += playerSpeed;
        }
        if ( left && playerX - playerSpeed >Main.BOARD_WIDTH/2){
            playerX -= playerSpeed;
        }
        if( right && playerX + playerSpeed +Main.CHAR_WIDTH  < Main.BOARD_WIDTH ){
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
        playerTwoDraw(g);
    }

    public void playerTwoDraw(Graphics g){
        g.drawImage(playerTwo, playerX, playerY, null);
    }

    @Override
    public void run() {
        while(true){
            try {
                keyProcess();
                System.out.println("thread 2 going");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
