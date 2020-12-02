package cocoafinalpj;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Ball {

    private Image ball;
    private int ballX = 100;
    private int ballY = 100;
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
        moveBall();
    }

    //TODO: 공 움직이기 구현하기!
    private void moveBall() {
        if (goDownY) {
            ballY += ballSpeed;
            if(ballY > Main.BOARD_HEIGHT){
                ballY = Main.BOARD_HEIGHT;
            }
        } else {
            ballY -= ballSpeed;
            if(ballY <0){
                ballY = 0;
            }
        }
        if (goLeftX) {
            ballX += ballSpeed;
            if(ballX > Main.BOARD_WIDTH){
                ballX = Main.BOARD_WIDTH;
            }
        } else {
            ballX -= ballSpeed;
            if(ballX < 0){
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
//        if(p1.getPlayerX() < ballX && ballX<p1.getPlayerX()+Main.PLAYER_WIDTH && ballY+Main.BALL_SIZE == p1.getPlayerY() ){
//            goDownY = false;
//        }

    }

}
