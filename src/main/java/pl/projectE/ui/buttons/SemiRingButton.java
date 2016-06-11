package pl.projectE.ui.buttons;


import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import pl.projectE.ui.geometry.SemiRingSection;
import pl.projectE.ui.annot.TransitionCall;

@SuppressWarnings("restriction")
public class SemiRingButton extends AnimatedButton {
    private Color color;

    public SemiRingButton(Color color, SemiRingSection semiRingSection) {
        shape = semiRingSection.getSemiRingSection();
        this.color = color;
        shape.setFill(color);
    }

    public void setHighlightedBehavior() {
        shape.setOnMouseEntered((e) -> shape.setFill(color.brighter()));
        shape.setOnMouseExited((e) -> shape.setFill(color));
    }

    @TransitionCall
    public void setAnimationBehavior(Shape path) {
    }

    public Shape getButton() {
        return shape;
    }

    public void setParentAnimationInvoker(SemiRingButton... relatedButtons) {
        shape.setOnMouseClicked((e) -> {
            transition.play();
            for (SemiRingButton b : relatedButtons) {
                b.transition.play();
            }
        });
    }
}
