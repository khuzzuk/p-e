package pl.projectE.ui.buttons;


import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import pl.projectE.geometry.SemiRingSection;
import pl.projectE.ui.annot.TransitionCall;

@SuppressWarnings("restriction")
public class SemiRingButton extends AnimatedButton {
    private double centerX, centerY, radius, innerRadius;
    private int startingAngle, endingAngle;
    private Color color;

    public SemiRingButton(double centerX, double centerY, double radius, double innerRadius,
                          int startingAngle, int endingAngle, Color color, SemiRingSection semiRingSection) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.innerRadius = innerRadius;
        this.startingAngle = startingAngle;
        this.endingAngle = endingAngle;
        shape = semiRingSection.getSemiRingSection();
        this.color = color;
        shape.setFill(color);
    }

    public void setHighlightedBehavior(){
        shape.setOnMouseEntered((e)->shape.setFill(color.brighter()));
        shape.setOnMouseExited((e)->shape.setFill(color));
    }

    @TransitionCall
    public void setAnimationBehavior(Shape path){
        shape.setOnMouseClicked((e)->transition.play());
    }

    public Shape getButton() {
        return shape;
    }
}
