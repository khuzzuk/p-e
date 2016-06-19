package pl.projectE.sec;

public class AccessPermissionsBenchmark {
    public static void main(String[] args) {
        new AccessPermissionsBenchmark().benchmark();
    }

    private void benchmark() {
        LimitedClass limitedClass = new LimitedClass();
        long start = System.currentTimeMillis();
        testLimited(limitedClass);
        long end = System.currentTimeMillis();
        System.out.println("Field with limited access: "+(end-start));
        start = System.currentTimeMillis();
        testNormal(limitedClass);
        end = System.currentTimeMillis();
        System.out.println("Field with public access: "+(end-start));
        start = System.currentTimeMillis();
        testWithSetter(limitedClass);
        end = System.currentTimeMillis();
        System.out.println("Field with setter access: "+(end-start));
        start = System.currentTimeMillis();
        testLimited(limitedClass);
        end = System.currentTimeMillis();
        System.out.println("Field with limited access: "+(end-start));
    }

    @Privileged
    private void testLimited(LimitedClass limitedClass){
        for (long x = 0; x<Integer.MAX_VALUE; x++) {
            limitedClass.limited = x;
        }
    }
    private void testNormal(LimitedClass limitedClass){
        for (long x = 0; x<Integer.MAX_VALUE; x++) {
            limitedClass.normal = x;
        }
    }
    private void testWithSetter(LimitedClass limitedClass){
        for (long x = 0; x<Integer.MAX_VALUE; x++) {
            limitedClass.setWithSetter(x);
        }
    }

    static class LimitedClass {
        @LimitedAccess
        long limited;
        long normal;
        long withSetter;

        public void setWithSetter(long withSetter) {
            this.withSetter = withSetter;
        }
    }
}
