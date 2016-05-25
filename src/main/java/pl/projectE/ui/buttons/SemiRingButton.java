package pl.projectE.ui.buttons;


import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import pl.projectE.geometry.SemiRingSection;
import pl.projectE.ui.transitions.Transitional;

@SuppressWarnings("restriction")
public class SemiRingButton implements Transitional {
    private double centerX, centerY, radius, innerRadius;
    private int startingAngle, endingAngle;
    private Color color;
    private Shape button;
    private ParallelTransition transition;

    public SemiRingButton(double centerX, double centerY, double radius, double innerRadius,
                          int startingAngle, int endingAngle, Color color, SemiRingSection semiRingSection) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.innerRadius = innerRadius;
        this.startingAngle = startingAngle;
        this.endingAngle = endingAngle;
        button = semiRingSection.getSemiRingSection();
        this.color = color;
        button.setFill(color);
    }

    public void setHighlightedBehavior(){
        button.setOnMouseEntered((e)->button.setFill(color.brighter()));
        button.setOnMouseExited((e)->button.setFill(color));
    }

    public void setAnimationBehavior(Shape path){
        PathTransition pathTransition = new PathTransition();
        applyValuesToTransition(pathTransition, button, path);
        RotateTransition rotateTransition = new RotateTransition();
        applyValuesToTransition(rotateTransition, button, -78);
        transition = combineTransitions(pathTransition, rotateTransition);
        button.setOnMouseClicked((e)->transition.play());
    }

    public Shape getButton() {
        return button;
    }
}
