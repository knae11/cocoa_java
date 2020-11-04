package mission2.초간단RPG;

import java.util.Scanner;

public class SimpleRPG {
    public GameField stage;
    public Status status;

    public SimpleRPG(Status status, GameField stage) {
        this.status = status;
        this.stage = stage;
    }

    private void levelUp(){
        this.status.level +=1;
        this.status.score+=1;
        this.status.mineNum = this.status.mineNum*2;
        System.out.println("level up : "+ this.status.level + " & " + "score : " +this.status.score + " & " + "mine numbers : " +this.status.mineNum );

    }


    public void printDead(){
        for(int j = 0; j<11; j++){
            for (int i = 0; i<11; i++){
                System.out.printf("%2s",this.status.field[j][i]);
            }
            System.out.println();
        }

    }

    public void move(){

        Scanner sc = new Scanner(System.in);

        System.out.println("w,a,s,d 중 하나를 입력해 주세요 (종료 : q)");
        while(sc.hasNext()) {
            String key = sc.next();
            this.status.field[this.status.currX][this.status.currY]="0";
            if (key.equals("w")) {
                this.status.currX -= 1;
            }
            if (key.equals("a")) {
                this.status.currY -= 1;
            }
            if (key.equals("s")) {
                this.status.currX += 1;
            }
            if (key.equals("d")) {
                this.status.currY += 1;
            }
            if(key.equals("q")){
                return;
            }
            if(this.status.field[this.status.currX][this.status.currY].equals(this.status.MONSTER)){
                System.out.println("you win, level up!!!");
                levelUp();
                this.stage.init();
                continue;
            }
            if(this.status.field[this.status.currX][this.status.currY].equals(this.status.MINE)){
                printDead();
                System.out.println("encounter mine, you lose!!!");
                return;
            }
            this.status.field[this.status.currX][this.status.currY]=this.status.CHARACTER;
            this.stage.print();

        }
        }

}
