package pl.projectE.ui.buttons;

import javafx.scene.control.Button;
import javafx.scene.shape.Circle;

public class ExitButton extends RoundButton {
    public ExitButton() {
        super();
        setText("X");
        setOnAction((e) -> System.exit(0));
    }
}
