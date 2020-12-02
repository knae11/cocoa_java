package cocoafinalpj;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Ball {

    private Image ball;
    private int ballX = 300;
    private int ballY = 300;
    private int ballSpeed = 2;
    private int ballSpeedUp = ballSpeed * 2;
    boolean goLeftX = true;
    boolean goDownY = true;
    private PlayerOne p1;
    private PlayerTwo p2;

    public Ball(PlayerOne p1, PlayerTwo p2) {
        ball = new ImageIcon("src/cocoafinalpj/image/ball.png").getImage();
        this.p1 = p1;
        this.p2 = p2;
    }

    public void ballDraw(Graphics g) {
        g.drawImage(ball, ballX, ballY, null);
        if(Math.abs(ballX - (p1.getPlayerX()+150))<50 && Math.abs(ballY - p1.getPlayerY())<30){
            System.out.println("hititititi");
        }
        //moveBall();
    }

    //TODO: 공 움직이기 구현하기!
    private void moveBall() {
        if (goDownY) {
            ballY += ballSpeed;
            if (ballY > Main.BOARD_HEIGHT) {
                ballY = Main.BOARD_HEIGHT;
            }
        } else {
            ballY -= ballSpeed;
            if (ballY < 0) {
                ballY = 0;
            }
        }
        if (goLeftX) {
            ballX += ballSpeed;
            if (ballX > Main.BOARD_WIDTH) {
                ballX = Main.BOARD_WIDTH;
            }
        } else {
            ballX -= ballSpeed;
            if (ballX < 0) {
                ballX = 0;
            }

        }
        determineBallDirection();

    }

    private void determineBallDirection() {
        //프레임
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
        //네트
        if (ballX + Main.BALL_SIZE < Main.BOARD_WIDTH / 2 - Main.NET_WIDTH / 2 + ballSpeed &&
            ballX + Main.BALL_SIZE > Main.BOARD_WIDTH / 2 - Main.NET_WIDTH / 2 - ballSpeed
            && ballY > Main.INIT_Y - Main.NET_HEIGHT) {
            goLeftX = false;
        }
        if (ballX < Main.BOARD_WIDTH / 2 + Main.NET_WIDTH / 2 + ballSpeed &&
            ballX > Main.BOARD_WIDTH / 2 + Main.NET_WIDTH / 2 - ballSpeed &&
            ballY > Main.INIT_Y - Main.NET_HEIGHT) {
            goLeftX = true;
        }
        //플레이어
        System.out.println("p1 : " + p1.getPlayerX()+", "+ p1.getPlayerY() +"// ball : "+ ballX + ", "+ ballY);
        if (p1.getPlayerX() + 150 < ballX && ballX < p1.getPlayerX() + 200
            && p1.getPlayerY() - ballSpeed < ballY && ballY < p1.getPlayerY() + ballSpeed) {
            goDownY= false;
        }

    }

}
