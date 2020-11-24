package mission7and8;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Omok extends Frame {
    private Frame f;
    public Omok(String title){
        init(title);
        bindEvents();
    }


    private void init(String title) {
        f = new Frame(title);
        f.setSize(500,500);
        f.setVisible(true);
    }

    private void bindEvents() {
        f.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    });

    }

}
