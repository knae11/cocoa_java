package mission2.초간단RPG;

import java.util.Scanner;

public class GameField {

    String[][] field = new String[11][11];
    PrintGame printGame = new PrintGame();
    Player p = new Player();
    LevelCheck level = new LevelCheck();

    static final String MONSTER = "👻";
    static final String MINE = "☀";
    static final String CHARACTER = "❤";

    private void randomPosition(String item){
        int i = (int)(Math.random()*10);
        int j = (int)(Math.random()*10);
        this.field[i][j] = item;
    }

    public void init(){
        for(int j = 0; j<11; j++){
            for (int i = 0; i<11; i++){
                this.field[j][i] = "0";
            }
        }
        for(int i =0; i<(level.getMineNum()); i++){
            randomPosition(MINE);
        }
        randomPosition(MONSTER);
        p.setX(5);
        p.setY(5);
        this.field[p.getX()][p.getY()]=CHARACTER;
        System.out.println("miniGame Starts");
        printGame.print(this.field);
        move();
    }

    public void move(){

        Scanner sc = new Scanner(System.in);

        System.out.println("w,a,s,d 중 하나를 입력해 주세요 (종료 : q)");
        while(sc.hasNext()) {
            String key = sc.next();
            this.field[p.getX()][p.getY()]="0";
            if (key.equals("w")) {
                p.moveUp();
            }
            if (key.equals("a")) {
                p.moveLeft();
            }
            if (key.equals("s")) {
                p.moveDown();
            }
            if (key.equals("d")) {
                p.moveRight();
            }
            if(key.equals("q")){
                return;
            }
            if(this.field[p.getX()][p.getY()].equals(GameField.MONSTER)){
                System.out.println("you win, level up!!!");
                level.levelUp();
                this.init();
                continue;
            }
            if(this.field[p.getX()][p.getY()].equals(GameField.MINE)){
                printGame.printDead(this.field);
                System.out.println("encounter mine, you lose!!!");
                //q의 경우에는 return 되는데 왜 안끝나지..? 미스테리
                return;
            }
            this.field[p.getX()][p.getY()]=GameField.CHARACTER;
            printGame.print(this.field);

        }
    }

}
