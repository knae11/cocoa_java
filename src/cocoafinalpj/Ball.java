package cocoafinalpj;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Ball {
    private Image ball;
    private int ballX = 100;
    private int ballY =100;
    private int ballSpeed = 5;
    private int ballSpeedUp = ballSpeed*2;


    public Ball(){
        ball = new ImageIcon("src/cocoafinalpj/image/ball.png").getImage();
    }

    public void ballDraw(Graphics g){
        g.drawImage(ball, ballX, ballY, null);
        moveBall();
    }
    //TODO: 공 움직이기 구현하기!
    private void moveBall() {
        ballX += ballSpeed;
        ballY+= ballSpeed;
    }

}
