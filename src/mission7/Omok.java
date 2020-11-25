package mission7;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Omok extends Frame {

    private final int LINE_NUM = 9;
    private final int LINE_WIDTH = 30;
    private final int BOARD_SIZE = LINE_WIDTH * (LINE_NUM - 1);
    private final int STONE_SIZE = (int) (LINE_WIDTH * 0.8);
    private final int CLICK_LEFT = 1024;
    private final int CLICK_RIGHT = 4096;

    private int X0;
    private int Y0;
    private int INSET_X;
    private int INSET_Y;

    private int FRAME_WIDTH;
    private int FRAME_HEIGHT;

    private Image img;
    private Graphics gImg;

    public Omok(String title) {
        super(title);
        init();
        bindEvents();
    }

    private void init() {
        setVisible(true);
        setBackground(Color.lightGray);
        Insets insets = getInsets();
        INSET_X = insets.left;
        INSET_Y = insets.top;
        X0 = INSET_X + LINE_WIDTH;
        Y0 = INSET_Y + LINE_WIDTH;
        FRAME_WIDTH = BOARD_SIZE + LINE_WIDTH * 2 + insets.left + insets.right;
        FRAME_HEIGHT = BOARD_SIZE + LINE_WIDTH * 2 + insets.top + insets.bottom;
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        img = createImage(FRAME_WIDTH, FRAME_HEIGHT);
        gImg = img.getGraphics();
        drawBoard(gImg);
    }

    private void bindEvents() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                handleStone(e);
            }
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void paint(Graphics g) {
        if (img == null) return;
        g.drawImage(img, 0, 0, this);
    }

    private void drawBoard(Graphics g) {
        for (int i = 0; i < LINE_NUM; i++) {
            g.drawLine(X0, Y0 + i * LINE_WIDTH, X0 + BOARD_SIZE, Y0 + i * LINE_WIDTH);
            g.drawLine(X0 + i * LINE_WIDTH, Y0, X0 + i * LINE_WIDTH, Y0 + BOARD_SIZE);
        }
    }

    private void handleStone(MouseEvent e){
        int x = e.getX();
        int y = e.getY();
        x = (x/LINE_WIDTH *LINE_WIDTH) + (x %LINE_WIDTH > LINE_WIDTH/2? LINE_WIDTH : 0) + INSET_X - (STONE_SIZE/2);
        y = (y/LINE_WIDTH *LINE_WIDTH) + (y %LINE_WIDTH > LINE_WIDTH/2? LINE_WIDTH : 0) - (STONE_SIZE/2);
        if( x< X0 -(LINE_WIDTH/2) || y< Y0 -(LINE_WIDTH/2) || x> X0+BOARD_SIZE || y> Y0+BOARD_SIZE ){
            System.out.println("out");
            return;
        }
        switch(e.getModifiersEx()){
            case CLICK_LEFT:
                drawWhiteStone(gImg, x, y);
                break;
            case CLICK_RIGHT:
                drawBlackStone(gImg, x, y);
                break;
            default:
                return;
        }
        repaint();
    }

    private void drawWhiteStone(Graphics g, int x, int y){
        g.setColor(Color.white);
        g.fillOval(x,y,STONE_SIZE, STONE_SIZE);
        g.setColor(Color.black);
        g.drawOval(x,y,STONE_SIZE, STONE_SIZE);
    }

    private void drawBlackStone(Graphics g, int x, int y){
        g.setColor(Color.black);
        g.fillOval(x,y,STONE_SIZE, STONE_SIZE);
    }
}
