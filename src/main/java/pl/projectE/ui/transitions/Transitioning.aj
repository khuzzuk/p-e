package pl.projectE.ui.transitions;

import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Transition;
import javafx.scene.Node;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

@SuppressWarnings("restriction")
public aspect Transitioning {
	Duration BASIC_DURATION = new Duration(300);
    void applyValuesToTransition(PathTransition transition, Node node, Shape path){
        transition.setInterpolator(Interpolator.EASE_OUT);
        transition.setDuration(BASIC_DURATION);
        transition.setNode(node);
        transition.setPath(path);
    }
    void applyValuesToTransition(RotateTransition transition, Node node, int angle){
        transition.setInterpolator(Interpolator.EASE_OUT);
        transition.setDuration(BASIC_DURATION);
        transition.setNode(node);
        transition.setByAngle(angle);
        transition.setFromAngle(0);
    }
    ParallelTransition combineTransitions(Transition... transitions){
        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(transitions);
        return parallelTransition;
    }

}
