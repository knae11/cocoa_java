package cocoafinalpj;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Ball {

    private Image ball;
    private int ballX = 100;
    private int ballY = 100;
    private int ballSpeed = 5;
    private int ballSpeedUp = ballSpeed * 2;
    boolean goLeftX = true;
    boolean goDownY = true;

    public Ball() {
        ball = new ImageIcon("src/cocoafinalpj/image/ball.png").getImage();
    }

    public void ballDraw(Graphics g) {
        g.drawImage(ball, ballX, ballY, null);
        moveBall();
    }

    //TODO: 공 움직이기 구현하기!
    private void moveBall() {
        if (goDownY) {
            ballY += ballSpeed;
        } else {
            ballY -= ballSpeed;
        }
        if (goLeftX) {
            ballX += ballSpeed;
        } else {
            ballX -= ballSpeed;
        }
        determineBallDirection();

    }

    private void determineBallDirection() {
        if (ballX + Main.BALL_SIZE == Main.BOARD_WIDTH) {
            goLeftX = false;
        }
        if (ballX == 0) {
            goLeftX = true;
        }
        if (ballY + Main.BALL_SIZE == Main.BOARD_HEIGHT) {
            goDownY = false;
        }
        if (ballY == 0) {
            goDownY = true;
        }
        if (ballX + Main.BALL_SIZE == Main.BOARD_WIDTH / 2 - Main.NET_WIDTH / 2
            && ballY > 300) {
            goLeftX = false;
        }
        if (ballX == Main.BOARD_WIDTH / 2 + Main.NET_WIDTH / 2
            && ballY > 300) {
            goLeftX = true;
        }

    }

}
