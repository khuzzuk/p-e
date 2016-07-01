package pl.projectE.ui.geometry;

import javafx.scene.paint.Color;
import pl.projectE.ui.buttons.SemiRingButton;

public class ShapeFactory {
    private static final SemiRingFactory semiRingFactory = new SemiRingFactory();
    private static final SemiRingSectionFactory semiRingSectionFactory = new SemiRingSectionFactory();
    public static SemiRingFactory semiRing(){
        return semiRingFactory;
    }
    public static SemiRingSectionFactory semiRingSection(){
        return semiRingSectionFactory;
    }
    public static class SemiRingFactory{
        double centerX=0, centerY=0, radius=1, innerRadius=0;

        public SemiRingFactory setCenterX(double centerX) {
            this.centerX = centerX;
            return this;
        }

        public SemiRingFactory setCenterY(double centerY) {
            this.centerY = centerY;
            return this;
        }

        public SemiRingFactory setRadius(double radius) {
            this.radius = radius;
            return this;
        }

        public SemiRingFactory setInnerRadius(double innerRadius) {
            this.innerRadius = innerRadius;
            return this;
        }
        public SemiRing build(){
            return new SemiRing(centerX,centerY,radius,innerRadius);
        }
    }
    public static class SemiRingSectionFactory{
        double centerX=0, centerY=0, radius=1, innerRadius=0;
        int startingAngle=0, endingAngle=0;

        public SemiRingSectionFactory setCenterX(double centerX) {
            this.centerX = centerX;
            return this;
        }

        public SemiRingSectionFactory setCenterY(double centerY) {
            this.centerY = centerY;
            return this;
        }

        public SemiRingSectionFactory setRadius(double radius) {
            this.radius = radius;
            return this;
        }

        public SemiRingSectionFactory setInnerRadius(double innerRadius) {
            this.innerRadius = innerRadius;
            return this;
        }

        public SemiRingSectionFactory setStartingAngle(int startingAngle) {
            this.startingAngle = startingAngle;
            return this;
        }

        public SemiRingSectionFactory setEndingAngle(int endingAngle) {
            this.endingAngle = endingAngle;
            return this;
        }

        public SemiRingSection build(){
            return new SemiRingSection(centerX,centerY,radius,innerRadius,startingAngle,endingAngle);
        }

        public SemiRingButton buildButton(Color color){
            return new SemiRingButton(color,
                    new SemiRingSection(centerX,centerY,radius,innerRadius,startingAngle,endingAngle));
        }
    }
}
