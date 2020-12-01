package cocoafinalpj;

import java.awt.image.BufferedImage;

public class PlayerOne extends Character {

    private BufferedImage playerOne;
    private String pathname = "resources/image/fox/leftwalk1.png";
    public PlayerOne(){
        super();
        playerOne = makeCharacter(pathname);

    }

    public BufferedImage getPlayerOne() {
        return playerOne;
    }


}
