package pl.projectE.ui.buttons;

import javafx.scene.control.Button;
import javafx.scene.shape.Circle;

abstract class RoundButton extends Button {
    RoundButton() {
        super();
        setShape(new Circle(0,0,1));
    }
}
