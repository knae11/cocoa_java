package mission8;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SelectSection extends Panel {

    private Button[] figuresButtons;
    private Button[] colorsButtons;
    private Button[] optionsButtons;
    private SetClickedData setClickedData;

    private final String[] figures = {
            "Free", "Square", "Circle", "Line", "Arc"
    };
    private final String[] colors = {
            "RED", "GREEN", "BLUE", "BLACK", "WHITE"
    };
    private final String[] options = {
            "ERASE", "FILL"
    };

    public SelectSection(SetClickedData data) {
        setClickedData = data;
        setBackground(Color.lightGray);
        setButtons();
    }

    private void setButtons() {
        setFiguresButtons();
        setColorsButtons();
        setOptionsButtons();
    }

    private void setColorsButtons() {
        colorsButtons = new Button[colors.length];
        for (int i = 0; i < colorsButtons.length; i++) {
            colorsButtons[i] = new Button(colors[i]);
            colorsButtons[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Button btn = (Button)e.getSource();
                    setClickedData.setColor(btn.getLabel());
                }
            });
            add(colorsButtons[i]);
        }
    }

    private void setOptionsButtons() {
        optionsButtons = new Button[options.length];
        for (int i = 0; i < optionsButtons.length; i++) {
            optionsButtons[i] = new Button(options[i]);
            add(optionsButtons[i]);
        }
    }

    private void setFiguresButtons() {
        figuresButtons = new Button[figures.length];
        for (int i = 0; i < figuresButtons.length; i++) {
            figuresButtons[i] = new Button(figures[i]);
            add(figuresButtons[i]);
        }
    }


}
