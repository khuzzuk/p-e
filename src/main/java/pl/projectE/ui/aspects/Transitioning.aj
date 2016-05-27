package pl.projectE.ui.aspects;

import javafx.animation.*;
import javafx.scene.Node;
import javafx.scene.shape.Shape;
import javafx.util.Duration;
import pl.projectE.ui.buttons.AnimatedButton;

@SuppressWarnings("restriction")
privileged public aspect Transitioning {
    private final Duration BASIC_DURATION = new Duration(300);
    before(Shape path, AnimatedButton element): execution(@TransitionCall * *(..)) && args(path) && target(element){
        PathTransition pathTransition = new PathTransition();
        applyValuesToTransition(pathTransition, element.shape, path);
        RotateTransition rotateTransition = new RotateTransition();
        applyValuesToTransition(rotateTransition, element.shape, -78);
        element.transition = combineTransitions(pathTransition, rotateTransition);
    }
    public void applyValuesToTransition(javafx.animation.PathTransition transition, Node node, Shape path) {
        transition.setInterpolator(Interpolator.EASE_OUT);
        transition.setDuration(BASIC_DURATION);
        transition.setNode(node);
        transition.setPath(path);
    }

    public void applyValuesToTransition(RotateTransition transition, Node node, int angle) {
        transition.setInterpolator(Interpolator.EASE_OUT);
        transition.setDuration(BASIC_DURATION);
        transition.setNode(node);
        transition.setByAngle(angle);
        transition.setFromAngle(0);
    }

    public ParallelTransition combineTransitions(Transition... transitions) {
        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(transitions);
        return parallelTransition;
    }
}
