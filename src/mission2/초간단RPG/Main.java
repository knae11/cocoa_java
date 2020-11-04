package mission2.초간단RPG;

public class Main {
    public static void main(String[] args) {
        Status status = new Status();
        GameField stage = new GameField(status);
        SimpleRPG miniGame = new SimpleRPG(status, stage);
        stage.setGame(miniGame);
        stage.init();
    }
}
