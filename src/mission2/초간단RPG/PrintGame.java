package mission2.초간단RPG;

public class PrintGame {

    public void print(String[][] field) {
        for (int j = 0; j < 11; j++) {
            for (int i = 0; i < 11; i++) {
                if (field[j][i].equals(GameField.MINE)) {
                    System.out.printf("%2s", "0");
                    continue;
                }
                System.out.printf("%2s", field[j][i]);
            }
            System.out.println();
        }
    }

    public void printDead(String[][] field){
        for(int j = 0; j<11; j++){
            for (int i = 0; i<11; i++){
                System.out.printf("%2s",field[j][i]);
            }
            System.out.println();
        }

    }
}