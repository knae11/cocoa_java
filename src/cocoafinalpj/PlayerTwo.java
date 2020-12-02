package cocoafinalpj;

import java.awt.Graphics;
import java.awt.Image;

public class PlayerTwo extends Character {


    private int playerX = Main.BOARD_WIDTH - (Main.INIT_X + Main.PLAYER_SIZE);
    private int playerY = Main.INIT_Y-Main.PLAYER_SIZE;

    private FoxStatus foxStatus;
    private final Image playerTwo;
    private final Image playerTwoJump;
    private final Image playerTwoDown;

    private final String defaultImage = path + "walk_left.png";
    private final String jumpImage = path +"jump_left.png";
    private final String downImage = path + "down_left.png";

    public PlayerTwo() {
        super();
        playerTwo = makeCharacter(defaultImage);
        playerTwoJump = makeCharacter(jumpImage);
        playerTwoDown = makeCharacter(downImage);
        foxStatus = FoxStatus.WALK_LEFT;

    }

    public int getPlayerX() {
        return playerX;
    }

    public int getPlayerY() {
        return playerY;
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
        if (right && playerX + playerSpeed + Main.PLAYER_SIZE < Main.BOARD_WIDTH) {
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
        keyProcess();
    }




}
