package cocoafinalpj;

public class Main {

    public static final int BOARD_WIDTH = 1200;
    public static final int BOARD_HEIGHT = 800;

    public static final int INIT_X = 100;
    public static final int INIT_Y = 600;
    public static final int CHAR_WIDTH = 200;
    public static final int CHAR_HEIGHT = 100;
    public static final int BALL_SIZE = 80;
    public static final int NET_WIDTH = 30;
    public static final int NET_HEIGHT = 300;

    public static void main(String[] args) {
        Game game = new Game();
        game.setVisible(true);
    }
}
