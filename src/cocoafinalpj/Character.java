package cocoafinalpj;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Character  {

    private Image character;
    public int playerSpeed = 30;

    public Character() {
        super();
    }

    public Image makeCharacter(String pathname) {
        character = new ImageIcon(pathname).getImage();
        return character;
    }



}
