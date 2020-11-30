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
    private BufferedImage characterOne;
    private BufferedImage characterTwo;
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
            characterOne = ImageIO.read(new File("resources/image/fox/leftwalk1.png"));
            characterTwo = ImageIO.read(new File("resources/image/fox/rightwalk1.png"));
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
        g.drawImage(characterOne, INIT_X,INIT_Y, null);
        g.drawImage(characterTwo, BOARD_WIDTH-(INIT_X+CHAR_WIDTH), INIT_Y, null);
        this.repaint();
    }
}
