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
        setTitle("nana game project");
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
        if(isPlaying){
            screenDraw(gImg);
        }else{
            screenGameOver(gImg);
        }
        g.drawImage(image, 0, 0, null);
    }

    private void screenGameOver(Graphics g) {
        g.drawImage(backgroundImage, 0, 0, null);
    }

    private void screenDraw(Graphics g) {
        g.drawImage(backgroundImage, 0, 0, null);
        g.drawImage(netImage,Main.BOARD_WIDTH/2 - Main.NET_WIDTH/2,Main.BOARD_HEIGHT/2,null );
        playerOne.playerDraw(g);
        playerTwo.playerDraw(g);
        ball.ballDraw(g);
        isPlaying = ball.getIsPlaying();
        this.repaint();
    }


    private void bindEvents() {
        addKeyListener(new KeyboardHandler(playerOne,playerTwo));
    }
}
