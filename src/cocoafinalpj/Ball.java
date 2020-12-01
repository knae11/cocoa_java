package cocoafinalpj;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Ball {
    private Image ball;
    private int ballX = 100;
    private int ballY =100;

    public Ball(){
        ball = new ImageIcon("src/cocoafinalpj/image/ball.png").getImage();
    }

    public void ballDraw(Graphics g){
        g.drawImage(ball, ballX, ballY, null);
    }

}
