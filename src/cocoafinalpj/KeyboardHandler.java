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
            System.out.println("2p down");
            playerTwo.setDown(true);
        }
        if (keyCode == KeyEvent.VK_UP) {
            System.out.println("2p up");
            playerTwo.setUp(true);
        }
        if (keyCode == KeyEvent.VK_LEFT) {
            System.out.println("2p left");
            playerTwo.setLeft(true);
        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            System.out.println("2p right");
            playerTwo.setRight(true);
        }
        if (keyCode == KeyEvent.VK_ENTER) {
            System.out.println("2p hit");
        }
        if (keyCode == KeyEvent.VK_W) {
            System.out.println("1p up");
            playerOne.setUp(true);
        }
        if (keyCode == KeyEvent.VK_A) {
            System.out.println("1p left");
            playerOne.setLeft(true);
        }
        if (keyCode == KeyEvent.VK_S) {
            System.out.println("1p down");
            playerOne.setDown(true);
        }
        if (keyCode == KeyEvent.VK_D) {
            System.out.println("1p right");
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
            System.out.println("2p down");
            playerTwo.setDown(false);
        }
        if (keyCode == KeyEvent.VK_UP) {
            System.out.println("2p up");
            playerTwo.setUp(false);
        }
        if (keyCode == KeyEvent.VK_LEFT) {
            System.out.println("2p left");
            playerTwo.setLeft(false);
        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            System.out.println("2p right");
            playerTwo.setRight(false);
        }
        if (keyCode == KeyEvent.VK_ENTER) {
            System.out.println("2p hit");
        }
        if (keyCode == KeyEvent.VK_W) {
            System.out.println("1p up release");
            playerOne.setUp(false);
        }
        if (keyCode == KeyEvent.VK_A) {
            System.out.println("1p left release");
            playerOne.setLeft(false);
        }
        if (keyCode == KeyEvent.VK_S) {
            System.out.println("1p down release");
            playerOne.setDown(false);
        }
        if (keyCode == KeyEvent.VK_D) {
            System.out.println("1p right release");
            playerOne.setRight(false);
        }
        if (keyCode == 16) {
            System.out.println("1p hit release");
        }
    }
}
