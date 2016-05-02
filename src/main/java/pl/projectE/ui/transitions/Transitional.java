package pl.projectE.ui.transitions;

import javafx.animation.*;
import javafx.scene.Node;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public interface Transitional {
    Duration BASIC_DURATION = new Duration(300);
    default void applyValuesToTransition(PathTransition transition, Node node, Shape path){
        transition.setInterpolator(Interpolator.EASE_OUT);
        transition.setDuration(BASIC_DURATION);
        transition.setNode(node);
        transition.setPath(path);
    }
    default void applyValuesToTransition(RotateTransition transition, Node node, int angle){
        transition.setInterpolator(Interpolator.EASE_OUT);
        transition.setDuration(BASIC_DURATION);
        transition.setNode(node);
        transition.setByAngle(angle);
        transition.setFromAngle(0);
    }
    default ParallelTransition combineTransitions(Transition... transitions){
        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(transitions);
        return parallelTransition;
    }
}
