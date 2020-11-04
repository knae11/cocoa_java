package mission2.초간단RPG;

import java.util.Scanner;

public class SimpleRPG {
    String[][] field = new String[11][11];
    private int level = 1;
    private int mineNum = 1;
    private int score = 1;
    int currX;
    int currY;
    final String MONSTER = "👻";
    final String MINE = "☀";
    final String CHARACTER = "❤";
    private void levelUp(){
        level +=1;
        score+=1;
        mineNum = mineNum*2;
        System.out.println("level up : "+ level + " & " + "score : " +score + " & " + "mine numbers : " +mineNum );

    }
    private void randomMonster(){
        int i = (int)(Math.random()*10);
        int j = (int)(Math.random()*10);
        this.field[i][j] = MONSTER;
    }
    private void randomMine(){
        int i = (int)(Math.random()*10);
        int j = (int)(Math.random()*10);
        this.field[i][j] = MINE;
    }
    public void init(){
        for(int j = 0; j<11; j++){
            for (int i = 0; i<11; i++){
                this.field[j][i] = "0";
            }
        }
        for(int i =0; i<(mineNum); i++){
            randomMine();
        }
        randomMonster();
        currX=5;
        currY=5;
        field[currX][currX]=CHARACTER;
        System.out.println("miniGame Starts");
        print();
        move();
    }

    public void printDead(){
        for(int j = 0; j<11; j++){
            for (int i = 0; i<11; i++){
                System.out.printf("%2s",field[j][i]);
            }
            System.out.println();
        }

    }
    private void print(){
        for(int j = 0; j<11; j++){
            for (int i = 0; i<11; i++){
                if(field[j][i].equals(MINE)){
                    System.out.printf("%2s","0");
                    continue;
                }
                System.out.printf("%2s",field[j][i]);
            }
            System.out.println();
        }
    }
    public void move(){

        Scanner sc = new Scanner(System.in);

        System.out.println("w,a,s,d 중 하나를 입력해 주세요");
        while(sc.hasNext()) {
            String key = sc.next();
            field[currX][currY]="0";
            if (key.equals("w")) {
                currX -= 1;
            }
            if (key.equals("a")) {
                currY -= 1;
            }
            if (key.equals("s")) {
                currX += 1;
            }
            if (key.equals("d")) {
                currY += 1;
            }

            if(field[currX][currY].equals(MONSTER)){
                System.out.println("you win, level up!!!");
                levelUp();
                init();
                continue;
            }
            if(field[currX][currY].equals(MINE)){
                printDead();
                System.out.println("encounter mine, you lose!!!");
                return;
            }
            field[currX][currY]=CHARACTER;
            print();

        }
        }

}
