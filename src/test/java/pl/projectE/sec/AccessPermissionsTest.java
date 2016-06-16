package pl.projectE.sec;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccessPermissionsTest {
    @Test(groups = "fast", expectedExceptions = IllegalAccessError.class)
    public void checkIllegalAccess() throws Exception {
        LimitedClass limitedClass = new LimitedClass();
        limitedClass.myField = 1;
    }

    @Test(groups = "fast")
    @Privileged
    public void checkGrantedAccess() throws Exception {
        LimitedClass limitedClass = new LimitedClass();
        limitedClass.myField = 1;
        assertThat(limitedClass.myField).isEqualTo(1);
    }

    public static void main(String[] args) {
        benchmark();
    }

    @Privileged
    private static void benchmark() {
        long startTime, endTime;
        LimitedClass limitedClass = new LimitedClass();
        startTime = System.nanoTime();
        for (int y = 0; y < 2; y++)
            for (int x = 0; x < Integer.MAX_VALUE; x++)
                limitedClass.myField = x;
        endTime = System.nanoTime();
        System.out.println("operation took " + (endTime - startTime) / 1000000);


        startTime = System.nanoTime();
        for (int y = 0; y < 2; y++)
            for (int x = 0; x < Integer.MAX_VALUE; x++)
                limitedClass.accessibleField = x;
        endTime = System.nanoTime();
        System.out.println("operation took " + (endTime - startTime) / 1000000);


        startTime = System.nanoTime();
        for (int y = 0; y < 2; y++)
            for (int x = 0; x < Integer.MAX_VALUE; x++)
                limitedClass.setPrivateField(x);
        endTime = System.nanoTime();
        System.out.println("operation took " + (endTime - startTime) / 1000000);
    }
}

class LimitedClass {
    @LimitedAccess
    public int myField;
    public int accessibleField;
    private int privateField;

    public void setPrivateField(int privateField) {
        this.privateField = privateField;
    }
}