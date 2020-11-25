package mission8;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class DrawSection extends Canvas {

    private int x;
    private int y;

    public DrawSection() {
        setBackground(Color.orange);
        bindEvents();

    }

    private void bindEvents() {
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                x = e.getX();
                y = e.getY();
                repaint();
            }
        });
    }
    public void update(Graphics g){
        paint(g);
    }
    public void paint(Graphics g) {
       g.drawString("*", x,y);
    }
}
