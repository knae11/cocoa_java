package cocoafinalpj;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Ball {

    private Image ball;
    private int ballX = 300;
    private int ballY = 300;
    private final int ballSpeed = 3;
    private final int ballSpeedUp = ballSpeed * 2;
    boolean goLeftX = true;
    boolean goDownY = true;
    private final PlayerOne p1;
    private final PlayerTwo p2;

    public Ball(PlayerOne p1, PlayerTwo p2) {
        ball = new ImageIcon("src/cocoafinalpj/image/ball.png").getImage();
        this.p1 = p1;
        this.p2 = p2;
    }

    public void ballDraw(Graphics g) {
        g.drawImage(ball, ballX, ballY, null);
        moveBall();
    }

    //TODO: 공 움직이기 구현하기!
    private void moveBall() {
        if (goDownY) {
            ballY += ballSpeed;
            if (ballY + Main.BALL_SIZE > Main.BOARD_HEIGHT) {
                ballY = Main.BOARD_HEIGHT - Main.BALL_SIZE;
            }
        } else {
            ballY -= ballSpeed;
            if (ballY < 0) {
                ballY = 0;
            }
        }
        if (goLeftX) {
            ballX -= ballSpeed;
            if (ballX < 0) {
                ballX = 0;
            }
        } else {
            ballX += ballSpeed;
            if (ballX + Main.BALL_SIZE > Main.BOARD_WIDTH) {
                ballX = Main.BOARD_WIDTH - Main.BALL_SIZE;
            }

        }
        determineBallDirection();

    }

    private void determineBallDirection() {
        //프레임
        if (ballX + Main.BALL_SIZE == Main.BOARD_WIDTH) {
            goLeftX = true;
        }
        if (ballX == 0) {
            goLeftX = false;
        }
        if (ballY + Main.BALL_SIZE == Main.BOARD_HEIGHT) {
            goDownY = false;
        }
        if (ballY == 0) {
            goDownY = true;
        }
        //네트
        if (Math.abs((Main.BOARD_WIDTH - Main.NET_WIDTH) / 2 - (ballX + Main.BALL_SIZE)) < ballSpeed
            && ballY > Main.INIT_Y - Main.NET_HEIGHT) {
            goLeftX = true;
        }
        if (Math.abs((Main.BOARD_WIDTH + Main.NET_WIDTH) / 2 - ballX) < ballSpeed &&
            ballY > Main.INIT_Y - Main.NET_HEIGHT) {
            goLeftX = false;
        }
        //플레이어
        //1P
        if (Math.abs((ballX + Main.BALL_SIZE / 2) - (p1.getPlayerX() + Main.PLAYER_SIZE)) < Main.BALL_SIZE/2
            && Math.abs((ballY + Main.BALL_SIZE / 2) - p1.getPlayerY()) < Main.BALL_SIZE/2) {
            goDownY = false;
        }
        if (Math.abs((ballX + Main.BALL_SIZE / 2) - p1.getPlayerX() ) < Main.BALL_SIZE/2
            && Math.abs((ballY + Main.BALL_SIZE / 2) - p1.getPlayerY()) < Main.BALL_SIZE/2) {
            goDownY = false;
        }
        //2P
        if (Math.abs(p2.getPlayerX()-(ballX + Main.BALL_SIZE / 2)) < Main.BALL_SIZE/2
            && Math.abs((ballY + Main.BALL_SIZE / 2) - p2.getPlayerY()) < Main.BALL_SIZE/2) {
            goDownY = false;
        }
        if (Math.abs(p2.getPlayerX()+Main.PLAYER_SIZE-(ballX + Main.BALL_SIZE / 2)) < Main.BALL_SIZE/2
            && Math.abs((ballY + Main.BALL_SIZE / 2) - p2.getPlayerY()) < Main.BALL_SIZE/2) {
            goDownY = false;
        }
    }

}
