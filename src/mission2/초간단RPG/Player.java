package mission2.초간단RPG;

public class Player {
    int currX;
    int currY;
    public int setX(int x){
       return this.currX = x;
    }
    public int setY(int y){
       return this.currY=y;
    }

    public int getX(){
        return this.currX;
    }
    public int getY(){
        return this.currY;
    }
    public int moveUp(){
       return this.currX -= 1;
    }
    public int moveLeft(){
        return this.currY -= 1;
    }
    public int moveDown(){
        return this.currX += 1;
    }
    public int moveRight(){
        return this.currY += 1;
    }
}
