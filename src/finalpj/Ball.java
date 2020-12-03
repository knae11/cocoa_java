package finalpj;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Ball {

    private final Image ball;
    private int ballX = 100;
    private int ballY = 100;
    private final int ballSpeed = 3;
    private final int ballSpeedUp = ballSpeed * 2;
    private boolean goLeftX = true;
    private boolean goDownY = true;
    private final PlayerOne p1;
    private final PlayerTwo p2;
    private boolean isPlaying = true;
    private boolean hit = false;

    public Ball(PlayerOne p1, PlayerTwo p2) {
        ball = new ImageIcon("src/finalpj/image/ball.png").getImage();
        this.p1 = p1;
        this.p2 = p2;
    }

    public void setHit(boolean hit) {
        //p1 정면 + hit
        if (Math.abs((ballX + Main.BALL_SIZE / 2) - (p1.getPlayerX() + Main.PLAYER_SIZE))
            < Main.BALL_SIZE / 2
            && Math.abs((ballY + Main.BALL_SIZE / 2) - p1.getPlayerY()) < Main.BALL_SIZE / 2) {
            this.hit = hit;
        }
        //p2 정면 + hit
        if (Math.abs(p2.getPlayerX() - (ballX + Main.BALL_SIZE / 2)) < Main.BALL_SIZE / 2
            && Math.abs((ballY + Main.BALL_SIZE / 2) - p2.getPlayerY()) < Main.BALL_SIZE / 2) {
            this.hit = hit;
        }
    }

    public void ballDraw(Graphics g) {
        g.drawImage(ball, ballX, ballY, null);
        if (hit) {
            moveBall(ballSpeedUp);
        } else {
            moveBall(ballSpeed);
        }
    }

    public boolean getWinner() {
        return ballX > Main.BOARD_WIDTH/2;
    }


    private void moveBall(int ballSpeed) {
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
        gameOver();

    }

    private void gameOver() {
        if (ballY + Main.BALL_SIZE > Main.INIT_Y) {
            isPlaying = false;
        }
    }


    public boolean getIsPlaying() {
        return isPlaying;
    }

    private void determineBallDirection() {
        frameBounce();
        netBounce();
        pOneBounce();
        pTwoBounce();
    }

    private void pTwoBounce() {
        //앞에서 올때
        if (Math.abs(p2.getPlayerX() - (ballX + Main.BALL_SIZE / 2)) < Main.BALL_SIZE / 2
            && Math.abs((ballY + Main.BALL_SIZE / 2) - p2.getPlayerY()) < Main.BALL_SIZE / 2) {
            goDownY = false;
            hit = false;
        }
        //뒤에서 올때
        if (Math.abs(p2.getPlayerX() + Main.PLAYER_SIZE - (ballX + Main.BALL_SIZE / 2))
            < Main.BALL_SIZE / 2
            && Math.abs((ballY + Main.BALL_SIZE / 2) - p2.getPlayerY()) < Main.BALL_SIZE / 2) {
            goDownY = false;
            hit = false;
        }
    }

    private void pOneBounce() {
        //앞에서 올때
        if (Math.abs((ballX + Main.BALL_SIZE / 2) - (p1.getPlayerX() + Main.PLAYER_SIZE))
            < Main.BALL_SIZE / 2
            && Math.abs((ballY + Main.BALL_SIZE / 2) - p1.getPlayerY()) < Main.BALL_SIZE / 2) {
            goDownY = false;
            hit = false;
        }
        //뒤에서 올때
        if (Math.abs((ballX + Main.BALL_SIZE / 2) - p1.getPlayerX()) < Main.BALL_SIZE / 2
            && Math.abs((ballY + Main.BALL_SIZE / 2) - p1.getPlayerY()) < Main.BALL_SIZE / 2) {
            goDownY = false;
            hit = false;
        }
    }

    private void netBounce() {
        if (Math.abs((Main.BOARD_WIDTH - Main.NET_WIDTH) / 2 - (ballX + Main.BALL_SIZE)) < ballSpeed
            && ballY > Main.INIT_Y - Main.NET_HEIGHT) {
            goLeftX = true;
        }
        if (Math.abs((Main.BOARD_WIDTH + Main.NET_WIDTH) / 2 - ballX) < ballSpeed &&
            ballY > Main.INIT_Y - Main.NET_HEIGHT) {
            goLeftX = false;
        }
    }

    private void frameBounce() {
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
    }

}
