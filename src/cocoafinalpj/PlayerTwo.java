package cocoafinalpj;

import java.awt.image.BufferedImage;

public class PlayerTwo extends  Character {

    private BufferedImage playerTwo;
    private String pathname = "resources/image/fox/rightwalk1.png";
    public PlayerTwo(){
        super();
        playerTwo = makeCharacter(pathname);

    }

    public BufferedImage getPlayerTwo() {
        return playerTwo;
    }


}
