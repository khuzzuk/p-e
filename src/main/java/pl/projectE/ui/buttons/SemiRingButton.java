package pl.projectE.ui.buttons;


import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import pl.projectE.geometry.SemiRing;
import pl.projectE.geometry.SemiRingSection;

public class SemiRingButton {
    private double centerX, centerY, radius, innerRadius;
    private int startingAngle, endingAngle;
    private Shape button;

    public SemiRingButton(double centerX, double centerY, double radius, double innerRadius,
                          int startingAngle, int endingAngle, Color color, SemiRingSection semiRingSection) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.innerRadius = innerRadius;
        this.startingAngle = startingAngle;
        this.endingAngle = endingAngle;
        button = semiRingSection.getSemiRingSection();
        button.setFill(color);
    }

    public Shape getButton() {
        return button;
    }
}
