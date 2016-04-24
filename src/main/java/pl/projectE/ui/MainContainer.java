package pl.projectE.ui;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import pl.projectE.ui.buttons.ExitButton;
import pl.projectE.ui.buttons.MinimizeButton;

public interface MainContainer {
    double BUTTON_SCALE = 0.025;
    default void addBasicButtons(AnchorPane pane){
        double maxX = pane.getWidth();
        double maxY = pane.getHeight();
        double max = Math.max(maxX,maxY);

        Button exitButton = new ExitButton();
        AnchorPane.setLeftAnchor(exitButton, maxX-maxX*0.04);
        AnchorPane.setTopAnchor(exitButton, maxY*0.02);
        exitButton.setMaxSize(max*BUTTON_SCALE, max*BUTTON_SCALE);
        exitButton.setMinSize(max*BUTTON_SCALE, max*BUTTON_SCALE);

        Button minimizeButton = new MinimizeButton();
        AnchorPane.setLeftAnchor(minimizeButton, maxX-maxX*0.07);
        AnchorPane.setTopAnchor(minimizeButton, maxY*0.02);
        minimizeButton.setMaxSize(max*BUTTON_SCALE, max*BUTTON_SCALE);
        minimizeButton.setMinSize(max*BUTTON_SCALE, max*BUTTON_SCALE);

        pane.getChildren().addAll(exitButton, minimizeButton);
    }
}