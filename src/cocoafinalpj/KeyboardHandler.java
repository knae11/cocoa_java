package cocoafinalpj;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardHandler  extends KeyAdapter {
    private Character playerOne,  playerTwo;
    public KeyboardHandler(Character p1, Character p2){
        playerOne = p1;
        playerTwo = p2;

    }
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_DOWN) {
            playerTwo.setDown(true);
        }
        if (keyCode == KeyEvent.VK_UP) {
            playerTwo.setUp(true);
        }
        if (keyCode == KeyEvent.VK_LEFT) {
            playerTwo.setLeft(true);
        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            playerTwo.setRight(true);
        }
        if (keyCode == KeyEvent.VK_ENTER) {
            System.out.println("2p hit");
        }
        if (keyCode == KeyEvent.VK_W) {
            playerOne.setUp(true);
        }
        if (keyCode == KeyEvent.VK_A) {
            playerOne.setLeft(true);
        }
        if (keyCode == KeyEvent.VK_S) {
            playerOne.setDown(true);
        }
        if (keyCode == KeyEvent.VK_D) {
            playerOne.setRight(true);
        }
        if (keyCode == 16) {
            System.out.println("1p hit");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_DOWN) {
            playerTwo.setDown(false);
        }
        if (keyCode == KeyEvent.VK_UP) {
            playerTwo.setUp(false);
        }
        if (keyCode == KeyEvent.VK_LEFT) {
            playerTwo.setLeft(false);
        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            playerTwo.setRight(false);
        }
        if (keyCode == KeyEvent.VK_ENTER) {
            System.out.println("2p hit");
        }
        if (keyCode == KeyEvent.VK_W) {
            playerOne.setUp(false);
        }
        if (keyCode == KeyEvent.VK_A) {
            playerOne.setLeft(false);
        }
        if (keyCode == KeyEvent.VK_S) {
            playerOne.setDown(false);
        }
        if (keyCode == KeyEvent.VK_D) {
            playerOne.setRight(false);
        }
        if (keyCode == 16) {
            System.out.println("1p hit release");
        }
    }
}
