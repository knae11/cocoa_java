package cocoafinalpj;

import java.awt.Graphics;
import java.awt.Image;

public class PlayerTwo extends Character implements Runnable {


    private int playerX = Main.BOARD_WIDTH-(Main.INIT_X+Main.CHAR_WIDTH);
    private int playerY = Main.INIT_Y;

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


    public void playerDraw(Graphics g){
        g.drawImage(playerTwo, playerX, playerY, null);
    }

    @Override
    public void run() {
        while(true){
            try {
                keyProcess();
                //System.out.println("thread 2 going");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
