package pl.projectE.ui.buttons;

import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MinimizeButton extends RoundButton {
    public MinimizeButton() {
        super();
        setText("-");
        setOnAction((e) -> ((Stage)getScene().getWindow()).setIconified(true));
    }
}
