package mission8;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class DrawSection extends Canvas {

    private int x;
    private int y;

    private SetClickedData setClickedData;

    public DrawSection(SetClickedData data) {
        setClickedData = data;
        setBackground(Color.orange);
        bindEvents();

    }

    private void bindEvents() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                x = e.getX();
                y = e.getY();
                repaint();
            }
        });
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
        switch (setClickedData.getFigure()) {
            case "Square":
                g.drawRect(x, y, 150, 300);
                break;
            case "Circle":
                g.drawOval(x, y, 100, 100);
                break;
            case "Line":
                g.drawLine(x, y, x + 50, y + 50);
                break;
            case "Arc":
                g.drawArc(x, y, 100, 40, 30, 130);
                break;
            case "Free":
            default:
                g.drawString("*", x, y);
                break;
        }
    }
}
