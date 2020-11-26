package mission8;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DrawingBoard extends Frame {

    private static final int BOARD_WIDTH = 800;
    private static final int BOARD_HEIGHT = 800;

    public DrawingBoard(){
        super("DrawingBoard by Nana");
        SetClickedData data = new SetClickedData();
        init(data);
        bindEvents();
    }

    private void init(SetClickedData data){
        setSize(BOARD_WIDTH,BOARD_HEIGHT);
        setLayout(new BorderLayout());
        add("North", new SelectSection(data));
        add("Center",new DrawSection(data));
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
