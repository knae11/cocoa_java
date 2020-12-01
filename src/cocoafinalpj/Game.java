package cocoafinalpj;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Game extends JFrame {

    private static final int BOARD_WIDTH = 1200;
    private static final int BOARD_HEIGHT = 800;
    private static final int INIT_X = 100;
    private static final int INIT_Y = 600;
    private static final int CHAR_WIDTH =200;

    private BufferedImage backgroundImage;
    private BufferedImage playerOne;
    private BufferedImage playerTwo;
    private Image image;
    private Graphics gImg;

    public Game() {
        initUI();
        setResource();
    }

    private void initUI() {
        setTitle("nana game project");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(BOARD_WIDTH, BOARD_HEIGHT);
    }

    private void setResource() {

        try {
            backgroundImage = ImageIO.read(new File("./resources/image/background.jpg"));
            playerOne = new PlayerOne().getPlayerOne();
            playerTwo = new PlayerTwo().getPlayerTwo();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics g){
        image = createImage(BOARD_WIDTH, BOARD_HEIGHT);
        gImg = image.getGraphics();
        backgroundDraw(gImg);
        g.drawImage(image, 0, 0, null);

    }

    private void backgroundDraw(Graphics g) {
        g.drawImage(backgroundImage, 0, 0, null);
        g.drawImage(playerOne, INIT_X,INIT_Y, null);
        g.drawImage(playerTwo, BOARD_WIDTH-(INIT_X+CHAR_WIDTH), INIT_Y, null);
        this.repaint();
    }
}
