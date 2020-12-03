package finalpj;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

public class PlayerOne extends Character {

    private final Image playerOne;
    private final Image playerOneJump;
    private final Image playerOneDown;
    private final ArrayList<Image> winner = new ArrayList<>();
    private final ArrayList<Image> loser = new ArrayList<>();
    private final String defaultImage = path + "walk_right.png";
    private final String jumpImage = path + "jump_right.png";
    private final String downImage = path + "down_right.png";
    private final String happy1 = path + "happy1.png";
    private final String happy2 = path + "happy2.png";
    private final String sad1 = path + "sad1.png";
    private final String sad2 = path + "sad2.png";

    private int playerX = Main.INIT_X;
    private int playerY = Main.INIT_Y - Main.PLAYER_SIZE;
    private CharacterStatus characterStatus;

    public PlayerOne() {
        super();
        playerOne = makeCharacter(defaultImage);
        playerOneJump = makeCharacter(jumpImage);
        playerOneDown = makeCharacter(downImage);
        winner.add(makeCharacter(happy1));
        winner.add(makeCharacter(happy2));
        loser.add(makeCharacter(sad1));
        loser.add(makeCharacter(sad2));
        characterStatus = CharacterStatus.WALK_RIGHT;
    }

    public int getPlayerX() {
        return playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    public Image getWinner(int i) {
        return this.winner.get(i);
    }

    public Image getLoser(int i) {
        return this.loser.get(i);
    }

    public void keyProcess() {
        if (up && playerY - playerSpeed > 0) {
            playerY -= playerSpeed;
            characterStatus = CharacterStatus.UP;
        }
        if (down && playerY + playerSpeed + Main.PLAYER_SIZE < Main.INIT_Y) {
            playerY += playerSpeed;
            characterStatus = CharacterStatus.DOWN;
        }
        if (left && playerX - playerSpeed > 0) {
            playerX -= playerSpeed;
            characterStatus = CharacterStatus.WALK_LEFT;
        }
        if (right && playerX + playerSpeed + Main.PLAYER_SIZE < Main.BOARD_WIDTH / 2) {
            playerX += playerSpeed;
            characterStatus = CharacterStatus.WALK_RIGHT;
        }
    }

    public void playerDraw(Graphics g) {
        switch (characterStatus) {
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
        keyProcess();
    }

}
