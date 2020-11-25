package mission7;

import java.awt.*;
import java.awt.event.*;

public class Bingo {
    public void bingoSample(){
        Frame f = new Frame("Bingo Game");
        f.setSize(500,500);

        //north
        Label title = new Label("Click Buttons, Mini Bingo Game!", Label.CENTER);
        f.add("North", title);

        //center : bingo grid
        Panel bingoPanel = new Panel();
        Button[] bingoBtns = null;
        bingoPanel.setLayout(new GridLayout(5,5,10,10));
        bingoPanel.setBackground(Color.PINK);
        f.add("Center", bingoPanel );

        String[] bingoStr = {
                "Coffee","Bread","Ice-cream","Chocolate","Candy",
                "Java","Python","JavaScript","React","CS",
                "Again","Why","Korean","is not","shown",
                "Archi","Design","Pattern","Layout","Composition",
                "Covid","gets","away","from","here"
        };
        bingoBtns = new Button[bingoStr.length];
        //btn click Event Handler
        class ChangeBackgroundHandler extends MouseAdapter{
            Button bingoBtn;
            ChangeBackgroundHandler(Button bingoBtn) {
                this.bingoBtn = bingoBtn;
            }
            public void mouseClicked(MouseEvent e) {
                Button btn = (Button)e.getSource();
                System.out.println(btn.getLabel());
                bingoBtn.setBackground(Color.lightGray);
            }
        }
        //Window close Event Handler
        class CloseWindowHandler extends WindowAdapter {
            @Override
            public void windowClosing(WindowEvent e) {
                f.dispose();
            }
        }

        for ( int i = 0; i < bingoStr.length; i++ ){
            bingoBtns[i] = new Button(bingoStr[i]);
            bingoBtns[i].setForeground(Color.magenta);
            bingoBtns[i].addMouseListener(new ChangeBackgroundHandler(bingoBtns[i]));
            bingoPanel.add(bingoBtns[i]);
        }

        //frame settings
        f.addWindowListener(new CloseWindowHandler());
        f.setResizable(false);
        f.setVisible(true);
    }
}
