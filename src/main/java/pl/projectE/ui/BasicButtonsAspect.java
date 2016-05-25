package pl.projectE.ui;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import pl.projectE.ui.buttons.ExitButton;
import pl.projectE.ui.buttons.MinimizeButton;

@Aspect
public class BasicButtonsAspect {
    private double BUTTON_SCALE = 0.02;

    @Pointcut("execution(*.new()) && args(pane)")
    public void settingUpThePanel(AnchorPane pane){}

    @After("settingUpThePanel(pane)")
    public void addBasicButtons(AnchorPane pane){
        double maxX = pane.getWidth();
        double maxY = pane.getHeight();
        double max = Math.max(maxX,maxY);

        Button exitButton = new ExitButton();
        AnchorPane.setLeftAnchor(exitButton, maxX-maxX*0.03);
        AnchorPane.setTopAnchor(exitButton, maxY*0.015);
        exitButton.setMaxSize(max*BUTTON_SCALE, max*BUTTON_SCALE);
        exitButton.setMinSize(max*BUTTON_SCALE, max*BUTTON_SCALE);

        Button minimizeButton = new MinimizeButton();
        AnchorPane.setLeftAnchor(minimizeButton, maxX-maxX*0.055);
        AnchorPane.setTopAnchor(minimizeButton, maxY*0.015);
        minimizeButton.setMaxSize(max*BUTTON_SCALE, max*BUTTON_SCALE);
        minimizeButton.setMinSize(max*BUTTON_SCALE, max*BUTTON_SCALE);

        pane.getChildren().addAll(exitButton, minimizeButton);
    }
}
