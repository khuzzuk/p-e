package pl.projectE.ui;

import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Shape;
import pl.projectE.geometry.ShapeFactory;
import pl.projectE.ui.buttons.SemiRingButton;

public interface CentralScreen {
    Color BACK_COLOR = new Color(0.85,0.85,0.85,1);
    Color FRONT_COLOR = new Color(0.95,0.95,0.95,1);
    Color BACKGROUND_COLOR = new Color(0.05,0.05,0.05,1);
    double OUTER_RADIUS_DIVISOR = 2.3;
    double INNER_RADIUS_DIVIDER = 3.2;
    int ANGLE_BORDER = 2;
    default void addCentralRing(AnchorPane pane){
        double width = pane.getWidth();
        double height = pane.getHeight();
        double min = Math.min(width,height);
        Shape ring = ShapeFactory.semiRing().setCenterX(width/2)
                .setCenterY(height/2)
                .setRadius(min/ OUTER_RADIUS_DIVISOR)
                .setInnerRadius(min/ INNER_RADIUS_DIVIDER).build().getSemiRing();

        RadialGradient gradient = new RadialGradient(0,0,width/2, height/2, min/ OUTER_RADIUS_DIVISOR,
                false, CycleMethod.NO_CYCLE,
                new Stop(1, BACK_COLOR), new Stop(0.86, FRONT_COLOR), new Stop(0.72, BACK_COLOR));
        ring.setFill(gradient);
        ring.setEffect(new DropShadow(80, BACK_COLOR));
        pane.getChildren().addAll(ring);
    }
    default void addButton(AnchorPane pane, int startingAngle, int endingAngle, Color color){
        double width = pane.getWidth();
        double height = pane.getHeight();
        double min = Math.min(width,height);
        SemiRingButton background = ShapeFactory.semiRingSection()
                .setCenterX(width/2)
                .setCenterY(height/2)
                .setRadius(min/OUTER_RADIUS_DIVISOR)
                .setInnerRadius(min/INNER_RADIUS_DIVIDER)
                .setStartingAngle(startingAngle-ANGLE_BORDER)
                .setEndingAngle(endingAngle+ANGLE_BORDER).buildButton(BACK_COLOR);
        SemiRingButton button = ShapeFactory.semiRingSection()
                .setStartingAngle(startingAngle)
                .setEndingAngle(endingAngle).buildButton(color);
        pane.getChildren().addAll(background.getButton(), button.getButton());
    }
}
