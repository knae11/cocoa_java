package mission8;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class DrawSection extends Canvas {

    private int x;
    private int y;

    private SetClickedData setClickedData;
    //TODO: color 받아와서 색성 변경하기
    public DrawSection(SetClickedData data) {
        setClickedData = data;
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

    public void update(Graphics g) {
        paint(g);
    }

    public void paint(Graphics g) {
        g.setColor(setClickedData.getColor());
        g.drawString("*", x,y);
    }
}
