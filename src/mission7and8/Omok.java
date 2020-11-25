package mission7and8;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Omok extends Frame {
    private Frame f;

    private final int LINE_NUM = 9;
    private final int LINE_WIDTH = 30;
    private final int BOARD_SIZE = LINE_WIDTH * (LINE_NUM - 1);
    private final int STONE_SIZE = (int) (LINE_WIDTH * 0.8);

    private int X0;
    private int Y0;

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
        X0 = insets.left + LINE_WIDTH;
        Y0 = insets.top + LINE_WIDTH;
        FRAME_WIDTH = BOARD_SIZE + LINE_WIDTH * 2 + insets.left + insets.right;
        FRAME_HEIGHT = BOARD_SIZE + LINE_WIDTH * 2 + insets.top + insets.bottom;
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        img = createImage(FRAME_WIDTH, FRAME_HEIGHT);
        gImg = img.getGraphics();
        drawBoard(gImg);
    }


    private void bindEvents() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    private void drawBoard(Graphics g) {
        System.out.println("drawBoard 호출");
        for (int i = 0; i < LINE_NUM; i++) {
            g.drawLine(X0, Y0 + i * LINE_WIDTH, X0 + BOARD_SIZE, Y0 + i * LINE_WIDTH);
            g.drawLine(X0 + i * LINE_WIDTH, Y0, X0 + i * LINE_WIDTH, Y0 + BOARD_SIZE);
        }}

        public void paint (Graphics g){
            System.out.println("Paint method 호출");
            if (img == null) return;
            g.drawImage(img, 0, 0, this);

        }

    }
