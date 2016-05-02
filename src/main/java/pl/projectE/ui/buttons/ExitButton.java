package pl.projectE.ui.buttons;

public class ExitButton extends RoundButton {
    public ExitButton() {
        super();
        setText("X");
        setOnAction((e) -> System.exit(0));
    }
}
