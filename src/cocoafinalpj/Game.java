package cocoafinalpj;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Game extends JFrame {


    private Image backgroundImage;
    private PlayerOne playerOne;
    private PlayerTwo playerTwo;
    private Image image;
    private Graphics gImg;

    public Game() {
        playerOne = new PlayerOne();
        Thread p1 = new Thread(playerOne);

        playerTwo = new PlayerTwo();
        Thread p2 = new Thread(playerTwo);
        p1.start();
        p2.start();
        initUI();
        setResource();
        bindEvents();
    }


    private void initUI() {
        setTitle("nana game project");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(Main.BOARD_WIDTH, Main.BOARD_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void setResource() {
        backgroundImage = new ImageIcon("src/cocoafinalpj/image/background.jpg").getImage();

    }

    public void paint(Graphics g) {
        image = createImage(Main.BOARD_WIDTH, Main.BOARD_HEIGHT);
        gImg = image.getGraphics();
        screenDraw(gImg);
        g.drawImage(image, 0, 0, null);
    }

    private void screenDraw(Graphics g) {
        g.drawImage(backgroundImage, 0, 0, null);
        playerOne.playerOneDraw(g);
        playerTwo.playerTwoDraw(g);
        this.repaint();
    }


    private void bindEvents() {
        addKeyListener(new KeyAdapter() {
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
        });
    }
}
