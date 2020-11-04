package mission2.초간단RPG;

public class GameField {

    public SimpleRPG game;
    public Status status;

    public GameField(Status status){
        this.status = status;
    }
    public void setGame(SimpleRPG game) {
        this.game = game;
    }

    private void randomMonster(){
        int i = (int)(Math.random()*10);
        int j = (int)(Math.random()*10);
        this.status.field[i][j] = this.status.MONSTER;
    }
    private void randomMine(){
        int i = (int)(Math.random()*10);
        int j = (int)(Math.random()*10);
        this.status.field[i][j] = this.status.MINE;
    }
    public void init(){
        for(int j = 0; j<11; j++){
            for (int i = 0; i<11; i++){
                this.status.field[j][i] = "0";
            }
        }
        for(int i =0; i<(this.status.mineNum); i++){
            randomMine();
        }
        randomMonster();
        this.status.currX=5;
        this.status.currY=5;
        this.status.field[this.status.currX][this.status.currX]=this.status.CHARACTER;
        System.out.println("miniGame Starts");
        print();
        this.game.move();
    }
    public void print(){
        for(int j = 0; j<11; j++){
            for (int i = 0; i<11; i++){
                if(this.status.field[j][i].equals(this.status.MINE)){
                    System.out.printf("%2s","0");
                    continue;
                }
                System.out.printf("%2s",this.status.field[j][i]);
            }
            System.out.println();
        }
    }

}
