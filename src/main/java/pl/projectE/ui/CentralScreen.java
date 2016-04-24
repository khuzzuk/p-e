package pl.projectE.ui;

import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Shape;
import pl.projectE.geometry.ShapeFactory;

public interface CentralScreen {
    double OUTER_RADIUS = 2.3;
    double INNER_RADIUS = 3.2;
    default void addCentralRing(AnchorPane pane){
        double width = pane.getWidth();
        double height = pane.getHeight();
        double min = Math.min(width,height);
        Shape ring = ShapeFactory.semiRing().setCenterX(width/2)
                .setCenterY(height/2)
                .setRadius(min/OUTER_RADIUS)
                .setInnerRadius(min/INNER_RADIUS).build().getSemiRing();
        RadialGradient gradient = new RadialGradient(0,.1,width/2, height/2, min/OUTER_RADIUS,
                false, CycleMethod.NO_CYCLE,
                new Stop(1,Color.GRAY), new Stop(0.87, Color.WHITE), new Stop(0.74, Color.GRAY));
        ring.setFill(gradient);
        ring.setEffect(new DropShadow(80, Color.BLACK));
        pane.getChildren().addAll(ring);
    }
}
