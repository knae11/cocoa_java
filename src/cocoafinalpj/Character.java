package cocoafinalpj;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Character extends JPanel {

    private BufferedImage character;

    public Character() {
        super();
    }

    public BufferedImage makeCharacter(String pathname) {
        try {
            character = ImageIO.read(new File(pathname));
            return character;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("exception : " + e.getMessage());
        }
        return character;
    }



}
