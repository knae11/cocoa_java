package cocoafinalpj;

import java.awt.Graphics;
import java.awt.Image;

public class PlayerOne extends Character implements Runnable {

    private int playerX = Main.INIT_X;
    private int playerY = Main.INIT_Y;
    private FoxStatus foxStatus;
    private Image playerOne;
    private Image playerOneJump;
    private Image playerOneDown;

    private String pathname = "src/cocoafinalpj/image/fox/leftwalk1.png";
    private String jumpImage = "src/cocoafinalpj/image/fox/jump_left.png";
    private String downImage ="src/cocoafinalpj/image/fox/down_left.png";

    public PlayerOne() {
        super();
        playerOne = makeCharacter(pathname);
        playerOneJump = makeCharacter(jumpImage);
        playerOneDown = makeCharacter(downImage);
        foxStatus = FoxStatus.WALK_RIGHT;
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
        if (left && playerX - playerSpeed > 0) {
            playerX -= playerSpeed;
            foxStatus = FoxStatus.WALK_LEFT;
        }
        if (right && playerX + playerSpeed + Main.CHAR_WIDTH < Main.BOARD_WIDTH / 2) {
            playerX += playerSpeed;
            foxStatus = FoxStatus.WALK_RIGHT;
        }
    }


    public void playerDraw(Graphics g) {switch (foxStatus) {
        case UP:
            g.drawImage(playerOneJump, playerX, playerY, null);
            break;
        case WALK_RIGHT:
        case WALK_LEFT:
            g.drawImage(playerOne, playerX, playerY, null);
            break;
        case DOWN:
            g.drawImage(playerOneDown, playerX, playerY, null);
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
                //System.out.println("thread 1 going");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
