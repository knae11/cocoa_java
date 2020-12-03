package finalpj;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Game extends JFrame {

    private final String imagePath = "src/finalpj/image/";

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
        getInstances();
        initUI();
        setResource();
        bindEvents();
    }

    private void getInstances() {
        playerOne = new PlayerOne();
        playerTwo = new PlayerTwo();
        ball = new Ball(playerOne, playerTwo);
    }


    private void initUI() {
        setTitle("With dino, pikachu game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(Main.BOARD_WIDTH, Main.BOARD_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void setResource() {
        backgroundImage = new ImageIcon(imagePath + "background.jpg").getImage();
        netImage = new ImageIcon(imagePath + "woodnet.jpg").getImage();
    }

    private void bindEvents() {
        addKeyListener(new KeyboardHandler(playerOne, playerTwo, ball));
    }

    public void paint(Graphics g) {
        image = createImage(Main.BOARD_WIDTH, Main.BOARD_HEIGHT);
        gImg = image.getGraphics();
        if (isPlaying) {
            screenGamePlay(gImg);
        } else {
            screenGameOver(gImg, endingFrame % 2);
            endingFrame++;
            try {
                Thread.sleep(500);
                g.drawImage(image, 0, 0, null);
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

    private void screenGamePlay(Graphics g) {
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


}
