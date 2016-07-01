package pl.projectE.ui.geometry;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class SemiRing {
    private final Shape semiring;

    SemiRing(double centerX, double centerY, double radius, double innerRadius){
        Circle outerCircle = new Circle(centerX,centerY,radius);
        Circle innerCircle = new Circle(centerX,centerY,innerRadius);
        semiring = Shape.subtract(outerCircle,innerCircle);
    }

    public Shape getSemiRing() {
        return semiring;
    }
}
