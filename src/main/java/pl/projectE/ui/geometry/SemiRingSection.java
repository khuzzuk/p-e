package pl.projectE.ui.geometry;

import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class SemiRingSection {
    private final Shape semiRingSection;

    SemiRingSection(double centerX, double centerY, double radius, double innerRadius,
                    int startingAngle, int endingAngle){
        Arc outerCircle = new Arc(centerX,centerY,radius,radius,startingAngle,endingAngle-startingAngle);
        outerCircle.setType(ArcType.ROUND);
        Circle innerCircle = new Circle(centerX,centerY,innerRadius);
        semiRingSection = Shape.subtract(outerCircle,innerCircle);
    }

    public Shape getSemiRingSection() {
        return semiRingSection;
    }
}
