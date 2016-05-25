package pl.projectE.ui.aspects;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import pl.projectE.ui.buttons.ExitButton;
import pl.projectE.ui.buttons.MinimizeButton;

@SuppressWarnings("restriction")
@Aspect
public class BasicMenuAspect {
	private final double BUTTON_SCALE = 0.02;

	@After("execution(* *setup*(javafx.scene.layout.AnchorPane)) && args(pane) && @within(pl.projectE.ui.annot.BasicContainer)")
	public void addBasicButtons(AnchorPane pane){
		double maxX = pane.getWidth();
		double maxY = pane.getHeight();
		double max = Math.max(maxX, maxY);

		Button exitButton = new ExitButton();
		AnchorPane.setLeftAnchor(exitButton, maxX - maxX * 0.025);
		AnchorPane.setTopAnchor(exitButton, maxY * 0.01);
		exitButton.setMaxSize(max * BUTTON_SCALE, max * BUTTON_SCALE);
		exitButton.setMinSize(max * BUTTON_SCALE, max * BUTTON_SCALE);

		Button minimizeButton = new MinimizeButton();
		AnchorPane.setLeftAnchor(minimizeButton, maxX - maxX * 0.05);
		AnchorPane.setTopAnchor(minimizeButton, maxY * 0.01);
		minimizeButton.setMaxSize(max * BUTTON_SCALE, max * BUTTON_SCALE);
		minimizeButton.setMinSize(max * BUTTON_SCALE, max * BUTTON_SCALE);

		pane.getChildren().addAll(exitButton, minimizeButton);
	}
}