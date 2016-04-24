package pl.projectE.ui.buttons;

import javafx.scene.control.Button;
import javafx.scene.shape.Circle;

public abstract class RoundButton extends Button {
    public RoundButton() {
        super();
        setShape(new Circle(0,0,1));
    }
}
