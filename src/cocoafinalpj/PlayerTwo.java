package cocoafinalpj;

import java.awt.Graphics;
import java.awt.Image;

public class PlayerTwo extends Character implements Runnable {


    private int playerX = Main.BOARD_WIDTH - (Main.INIT_X + Main.CHAR_WIDTH);
    private int playerY = Main.INIT_Y;

    private FoxStatus foxStatus;
    private Image playerTwo;
    private Image playerTwoJump;
    private Image playerTwoDown;
    private String defaultImage = "src/cocoafinalpj/image/fox/rightwalk1.png";
    private String jumpImage = "src/cocoafinalpj/image/fox/jump_right.png";
    private String downImage ="src/cocoafinalpj/image/fox/down_right.png";

    public PlayerTwo() {
        super();
        playerTwo = makeCharacter(defaultImage);
        playerTwoJump = makeCharacter(jumpImage);
        playerTwoDown = makeCharacter(downImage);
        foxStatus = FoxStatus.WALK_LEFT;

    }

    public void keyProcess() {
        if (up && playerY - playerSpeed > 0) {
            playerY -= playerSpeed;
            foxStatus = FoxStatus.UP;
        }
        if (down && playerY + playerSpeed < Main.INIT_Y) {
            playerY += playerSpeed;
            foxStatus = FoxStatus.DOWN;
        }
        if (left && playerX - playerSpeed > Main.BOARD_WIDTH / 2) {
            playerX -= playerSpeed;
            foxStatus = FoxStatus.WALK_LEFT;
        }
        if (right && playerX + playerSpeed + Main.CHAR_WIDTH < Main.BOARD_WIDTH) {
            playerX += playerSpeed;
            foxStatus = FoxStatus.WALK_RIGHT;
        }
    }


    public void playerDraw(Graphics g) {
        switch (foxStatus) {
            case UP:
                g.drawImage(playerTwoJump, playerX, playerY, null);
                break;
            case WALK_RIGHT:
            case WALK_LEFT:
                g.drawImage(playerTwo, playerX, playerY, null);
                break;
            case DOWN:
                g.drawImage(playerTwoDown, playerX, playerY, null);
                break;
            default:
                break;
        }
    }

    @Override
    public void run() {
        while (true) {
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