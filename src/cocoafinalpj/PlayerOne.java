package cocoafinalpj;

import java.awt.Graphics;
import java.awt.Image;

public class PlayerOne extends Character implements Runnable {

    private int playerX = Main.INIT_X;
    private int playerY = Main.INIT_Y;


    private Image playerOne;
    private String pathname = "src/cocoafinalpj/image/fox/leftwalk1.png";

    public PlayerOne() {
        super();
        playerOne = makeCharacter(pathname);
    }


    public void keyProcess() {
        if (up && playerY - playerSpeed > 0) {
            playerY -= playerSpeed;
        }
        if (down && playerY + playerSpeed < Main.INIT_Y) {
            playerY += playerSpeed;
        }
        if (left && playerX - playerSpeed > 0) {
            playerX -= playerSpeed;
        }
        if (right && playerX + playerSpeed + Main.CHAR_WIDTH < Main.BOARD_WIDTH / 2) {
            playerX += playerSpeed;
        }
    }


    public void playerDraw(Graphics g) {
        g.drawImage(playerOne, playerX, playerY, null);
    }

    @Override
    public void run() {
        while (true) {
            try {
                keyProcess();
                //System.out.println("thread 1 going");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
