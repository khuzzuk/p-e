package pl.projectE.ui.transitions;

import javafx.animation.*;
import javafx.scene.Node;
import javafx.scene.shape.Shape;
import javafx.util.Duration;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import pl.projectE.ui.buttons.AnimatedButton;

@Aspect
public class TransitioningAspect {
    private final Duration BASIC_DURATION = new Duration(300);

    @Pointcut("execution(@pl.projectE.ui.annot.TransitionCall * *(..))" +
            "&& args(path) && target(element)")
    public void transitionCall(Shape path, AnimatedButton element) {}

    @Before("transitionCall(path, element)")
    public void setTransition(Shape path, AnimatedButton element) {
        PathTransition pathTransition = new PathTransition();
        applyValuesToTransition(pathTransition, element.getShape(), path);
        RotateTransition rotateTransition = new RotateTransition();
        applyValuesToTransition(rotateTransition, element.getShape(), -80);
        element.setTransition(combineTransitions(pathTransition, rotateTransition));
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
