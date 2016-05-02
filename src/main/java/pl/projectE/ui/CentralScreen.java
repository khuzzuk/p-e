package pl.projectE.ui;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.*;
import pl.projectE.geometry.ShapeFactory;
import pl.projectE.ui.buttons.SemiRingButton;

public abstract class CentralScreen {
    public static final Color BACK_COLOR = new Color(0.5,0.5,0.5,1);
    public static final Color FRONT_COLOR = new Color(0.85,0.85,0.85,1);
    public static final Color BACKGROUND_COLOR = new Color(0.6,0.6,0.6,1);
    public static final Color SHADOW_COLOR = new Color(0.3,0.3,0.3,1);
    public static final double OUTER_RADIUS_DIVISOR = 2.3;
    public static final double INNER_RADIUS_DIVIDER = 3.2;
    public static final int ANGLE_BORDER = 2;
    protected Shape ring;
    protected SimpleDoubleProperty centerX;
    protected SimpleDoubleProperty centerY;
    protected final AnchorPane pane;
    private double radius;
    private double innerRadius;

    public CentralScreen(AnchorPane pane) {
        this.pane = pane;
    }

    protected void addCentralRing(){
        double width = pane.getWidth();
        double height = pane.getHeight();
        double min = Math.min(width,height);
        radius = min / OUTER_RADIUS_DIVISOR;
        innerRadius = min / INNER_RADIUS_DIVIDER;
        ring = ShapeFactory.semiRing().setCenterX(width/2)
                .setCenterY(height/2)
                .setRadius(radius)
                .setInnerRadius(innerRadius).build().getSemiRing();

        RadialGradient gradient = new RadialGradient(0,0,width/2, height/2, min / OUTER_RADIUS_DIVISOR,
                false, CycleMethod.NO_CYCLE,
                new Stop(1, BACK_COLOR), new Stop(0.86, FRONT_COLOR), new Stop(0.72, BACK_COLOR));
        ring.setFill(gradient);
        ring.setEffect(new DropShadow(80, SHADOW_COLOR));
        pane.getChildren().addAll(ring);
    }

    protected void addButton(AnchorPane pane, int startingAngle, int endingAngle, Color color){
        double width = pane.getWidth();
        double height = pane.getHeight();
        double min = Math.min(width,height);
        SemiRingButton background = createButtonBackground(startingAngle, endingAngle, width, height, min);
        SemiRingButton button = createButton(startingAngle, endingAngle, color);
        button.setHighlightedBehavior();
        Shape path;
        path = createEllipsePath(startingAngle+(endingAngle-startingAngle)/2, 80);
        button.setAnimationBehavior(path);
        pane.getChildren().addAll(background.getButton(), button.getButton());
    }

    private Arc createEllipsePath(int startingPoint, int endingPoint) {
        ArcTo arcTo = new ArcTo();
        arcTo.setX(pane.getWidth()/2);
        arcTo.setY(pane.getHeight()/2);
        arcTo.setRadiusX(radius);
        arcTo.setRadiusY(radius);
        double pathRadius = (radius+innerRadius)/2;
        Arc outerCircle = new Arc(pane.getWidth()/2,pane.getHeight()/2,pathRadius,pathRadius,startingPoint,endingPoint);
        outerCircle.setType(ArcType.OPEN);
        return outerCircle;
    }

    private SemiRingButton createButtonBackground(int startingAngle, int endingAngle, double width, double height, double min) {
        return ShapeFactory.semiRingSection()
                    .setCenterX(width/2)
                    .setCenterY(height/2)
                    .setRadius(min/OUTER_RADIUS_DIVISOR)
                    .setInnerRadius(min/INNER_RADIUS_DIVIDER)
                    .setStartingAngle(startingAngle-ANGLE_BORDER)
                    .setEndingAngle(endingAngle+ANGLE_BORDER).buildButton(BACK_COLOR);
    }

    private SemiRingButton createButton(int startingAngle, int endingAngle, Color color) {
        return ShapeFactory.semiRingSection()
                .setStartingAngle(startingAngle)
                .setEndingAngle(endingAngle).buildButton(color);
    }
}
