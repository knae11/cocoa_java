package mission8;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class DrawSection extends Canvas {


    private int x;
    private int y;

    private boolean isFill;

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
        isFill = setClickedData.getIsFill();
        switch (setClickedData.getFigure()) {
            case "Square":
                if (isFill) {
                    g.fillRect(x, y, 100, 100);
                }
                g.drawRect(x, y, 100, 100);
                break;
            case "Circle":
                if (isFill) {
                    g.fillOval(x, y, 100, 100);
                }
                g.drawOval(x, y, 100, 100);
                break;
            case "Line":
                g.drawLine(x, y, x + 100, y + 100);
                break;
            case "Arc":
                g.drawArc(x, y, 100, 100, 30, 150);
                break;
            case "Free":
            default:
                g.fillOval(x, y, 10, 10);
                break;
        }
    }
}
