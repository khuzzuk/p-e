package pl.projectE.ui.transitions;

import javafx.animation.*;
import javafx.scene.Node;
import javafx.scene.shape.Shape;
import javafx.util.Duration;
import pl.projectE.ui.buttons.AnimatedButton;

@SuppressWarnings("restriction")
privileged public aspect Transitioning {
    private final Duration BASIC_DURATION = new Duration(300);

    pointcut setTransition(Shape path, AnimatedButton element):
        execution(@pl.projectE.ui.annot.TransitionCall * *(..))
            && args(path) && target(element);

    before(Shape path, AnimatedButton element): setTransition(path, element){
        PathTransition pathTransition = new PathTransition();
        applyValuesToTransition(pathTransition, element.shape, path);
        RotateTransition rotateTransition = new RotateTransition();
        applyValuesToTransition(rotateTransition, element.shape, -80);
        element.transition = combineTransitions(pathTransition, rotateTransition);
    }
    private void applyValuesToTransition(javafx.animation.PathTransition transition, Node node, Shape path) {
        transition.setInterpolator(Interpolator.EASE_OUT);
        transition.setDuration(BASIC_DURATION);
        transition.setNode(node);
        transition.setPath(path);
    }

    private void applyValuesToTransition(RotateTransition transition, Node node, int angle) {
        transition.setInterpolator(Interpolator.EASE_OUT);
        transition.setDuration(BASIC_DURATION);
        transition.setNode(node);
        transition.setByAngle(angle);
        transition.setFromAngle(0);
    }

    private ParallelTransition combineTransitions(Transition... transitions) {
        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(transitions);
        return parallelTransition;
    }
}
