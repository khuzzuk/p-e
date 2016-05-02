package pl.projectE.ui;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class CirclePane extends CentralScreen {

    public CirclePane(AnchorPane pane) {
        super(pane);
    }

    public void addButton(int startingAngle, int endingAngle, Color color) {
        if (ring==null) addCentralRing();
        addButton(pane,startingAngle,endingAngle,color);
    }

    public AnchorPane getPane() {
        return pane;
    }
}
