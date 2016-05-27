package pl.projectE.ui.buttons;

import javafx.animation.ParallelTransition;
import javafx.scene.shape.Shape;

public abstract class AnimatedButton {
    ParallelTransition transition;
    protected Shape shape;

    protected void setTransition(ParallelTransition newTransition){
        transition = newTransition;
    }
    public abstract void setAnimationBehavior(Shape path);
}
