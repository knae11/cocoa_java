package cocoafinalpj;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Game extends JFrame {


    private Image backgroundImage;
    private Image netImage;
    private PlayerOne playerOne;
    private PlayerTwo playerTwo;
    private Ball ball;
    private Image image;
    private Graphics gImg;
    private boolean isPlaying = true;
    private boolean p1IsWinner = true;
    private int endingFrame = 0;

    public Game() {
        playerOne = new PlayerOne();
        //Thread p1 = new Thread(playerOne);
        playerTwo = new PlayerTwo();
        //  Thread p2 = new Thread(playerTwo);
        ball = new Ball(playerOne, playerTwo);
        //p1.start();
        //p2.start();
        initUI();
        setResource();
        bindEvents();
    }


    private void initUI() {
        setTitle("With dino, pikachu game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(Main.BOARD_WIDTH, Main.BOARD_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void setResource() {
        backgroundImage = new ImageIcon("src/cocoafinalpj/image/background.jpg").getImage();
        netImage = new ImageIcon("src/cocoafinalpj/image/woodnet.jpg").getImage();
    }

    public void paint(Graphics g) {
        image = createImage(Main.BOARD_WIDTH, Main.BOARD_HEIGHT);
        gImg = image.getGraphics();
        if (isPlaying) {
            screenDraw(gImg);
        } else {
            screenGameOver(gImg, endingFrame % 2);
            endingFrame++;
            try {
                g.drawImage(image, 0, 0, null);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("[Error]: 게임엔딩에서 에러발생함");
                System.exit(0);
            }
        }
        g.drawImage(image, 0, 0, null);
    }

    private void screenGameOver(Graphics g, int i) {
        g.drawImage(backgroundImage, 0, 0, null);
        if (p1IsWinner) {
            g.drawImage(playerOne.getWinner(i), Main.BOARD_WIDTH / 3 - Main.PLAYER_ENDING_SIZE,
                Main.BOARD_HEIGHT / 2, null);
            g.drawImage(playerTwo.getLoser(i), (Main.BOARD_WIDTH / 3) * 2, Main.BOARD_HEIGHT / 2,
                null);
        } else {
            g.drawImage(playerOne.getLoser(i), Main.BOARD_WIDTH / 3 - Main.PLAYER_ENDING_SIZE,
                Main.BOARD_HEIGHT / 2, null);
            g.drawImage(playerTwo.getWinner(i), (Main.BOARD_WIDTH / 3) * 2, Main.BOARD_HEIGHT / 2,
                null);
        }
        this.repaint();
    }

    private void screenDraw(Graphics g) {
        g.drawImage(backgroundImage, 0, 0, null);
        g.drawImage(netImage, Main.BOARD_WIDTH / 2 - Main.NET_WIDTH / 2, Main.BOARD_HEIGHT / 2,
            null);
        playerOne.playerDraw(g);
        playerTwo.playerDraw(g);
        ball.ballDraw(g);
        isPlaying = ball.getIsPlaying();
        if (!isPlaying) {
            p1IsWinner = ball.getWinner();
        }
        this.repaint();
    }


    private void bindEvents() {
        addKeyListener(new KeyboardHandler(playerOne, playerTwo, ball));
    }
}
