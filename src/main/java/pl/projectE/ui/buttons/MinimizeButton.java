package pl.projectE.ui.buttons;

import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class MinimizeButton extends RoundButton {
    public MinimizeButton() {
        super();
        setText("-");
        setOnAction((e) -> ((Stage)getScene().getWindow()).setIconified(true));
    }
}
