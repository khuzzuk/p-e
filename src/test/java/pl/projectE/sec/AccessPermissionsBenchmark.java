package pl.projectE.sec;

import com.google.caliper.BeforeExperiment;
import com.google.caliper.Param;

import java.util.function.Function;

public class AccessPermissionsBenchmark {
    private LimitedClass limitedClass;
    @Param({"100000", "1000000"})
    private int capacity;

    @Param({"AccessPermissions::testLimited"})
    private Function<LimitedClass, Long> method;

    @BeforeExperiment
    private void setup() {
        limitedClass = new LimitedClass();
    }


    private void benchmark() {

    }

    private Long testLimited(LimitedClass limitedClass){
        for (int x = 0; x<capacity; x++) {
            limitedClass.limited = x;
        }
        return 1L;
    }
    private Long testNormal(LimitedClass limitedClass){
        for (int x = 0; x<capacity; x++) {
            limitedClass.normal = x;
        }
        return 1L;
    }
    private Long testWithSetter(LimitedClass limitedClass){
        for (int x = 0; x<capacity; x++) {
            limitedClass.setWithSetter(x);
        }
        return 1L;
    }

    private static class LimitedClass {
        @LimitedAccess
        private int limited;
        private int normal;
        private int withSetter;

        public void setWithSetter(int withSetter) {
            this.withSetter = withSetter;
        }
    }
}
