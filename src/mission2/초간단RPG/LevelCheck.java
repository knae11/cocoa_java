package mission2.초간단RPG;

public class LevelCheck {
    private int level = 1;
    private int mineNum = 1;
    private int score = 1;

    public int getMineNum(){
        return this.mineNum;
    }
    public void levelUp(){
        this.level +=1;
        this.score+=1;
        this.mineNum = this.mineNum*2;
        System.out.println("level up : "+ this.level + " & " + "score : " +this.score + " & " + "mine numbers : " +this.mineNum );

    }
}
