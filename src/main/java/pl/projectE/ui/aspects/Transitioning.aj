package pl.projectE.ui.aspects;

import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Transition;
import javafx.scene.Node;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

@SuppressWarnings("restriction")
public aspect Transitioning {
    declare parents: @pl.projectE.ui.annot.Transitionable * implements pl.projectE.ui.transitions.Transitional;

        private final Duration BASIC_DURATION = new Duration(300);
        public void applyValuesToTransition(javafx.animation.PathTransition transition, Node node, Shape path){
            transition.setInterpolator(Interpolator.EASE_OUT);
            transition.setDuration(BASIC_DURATION);
            transition.setNode(node);
            transition.setPath(path);
        }
        public void applyValuesToTransition(RotateTransition transition, Node node, int angle){
            transition.setInterpolator(Interpolator.EASE_OUT);
            transition.setDuration(BASIC_DURATION);
            transition.setNode(node);
            transition.setByAngle(angle);
            transition.setFromAngle(0);
        }
        public ParallelTransition combineTransitions(Transition... transitions){
            ParallelTransition parallelTransition = new ParallelTransition();
            parallelTransition.getChildren().addAll(transitions);
            return parallelTransition;
        }
}
