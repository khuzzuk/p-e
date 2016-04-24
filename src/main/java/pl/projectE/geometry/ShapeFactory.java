package pl.projectE.geometry;

public class ShapeFactory {
    private static SemiRingFactory semiRingFactory = new SemiRingFactory();
    public static SemiRingFactory semiRing(){
        return semiRingFactory;
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
}
