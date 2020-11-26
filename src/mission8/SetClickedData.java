package mission8;

import java.awt.*;

public class SetClickedData {
    private String figure  = "Free";
    private Color color;

    public void setFigure(String figure){
        this.figure = figure;
        System.out.println(this.figure);
    }
    public String getFigure(){
        return this.figure;
    }


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
    }
    public Color getColor(){
        return this.color;
    }

}
