package mission8;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DrawingBoard extends Frame {

    private static final int BOARD_WIDTH = 800;
    private static final int BOARD_HEIGHT = 800;

    public DrawingBoard(){
        super("DrawingBoard by Nana");
        init();
        bindEvents();
    }

    private void init(){
        setSize(BOARD_WIDTH,BOARD_HEIGHT);
        add(new SelectSection(BOARD_WIDTH,BOARD_HEIGHT/5));
        add(new DrawSection());
        setVisible(true);
    }

    private void bindEvents(){
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
