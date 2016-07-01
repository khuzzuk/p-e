package pl.projectE.ui.buttons;

import javafx.animation.ParallelTransition;
import javafx.scene.shape.Shape;

public abstract class AnimatedButton {
    ParallelTransition transition;
    @SuppressWarnings("WeakerAccess")
    protected Shape shape;

    public void setTransition(ParallelTransition newTransition){
        transition = newTransition;
    }
    public abstract void setAnimationBehavior(Shape path);

    public Shape getShape() {
        return shape;
    }

    public ParallelTransition getTransition() {
        return transition;
    }
}
