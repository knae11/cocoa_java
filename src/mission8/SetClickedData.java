package mission8;

import java.awt.*;

public class SetClickedData {
    private Color color;

    public void setColor(String color){
        switch (color){
            case "RED":
                this.color = Color.RED;
                break;
            case "GREEN":
                this.color = Color.GREEN;
                break;
            case "BLUE":
                this.color = Color.BLUE;
                break;
            case "WHITE":
                this.color = Color.WHITE;
                break;
            case "BLACK":
                this.color = Color.BLACK;
                break;
            default:
                break;
        }
        System.out.println(this.color);
    }
    public Color getColor(){
        return this.color;
    }

}
