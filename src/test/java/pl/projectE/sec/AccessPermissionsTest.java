package pl.projectE.sec;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccessPermissionsTest {
    LimitedClass limitedClass;

    @BeforeMethod
    public void setUp() throws Exception {
        limitedClass = new LimitedClass();
    }

    @Test(groups = "fast", expectedExceptions = IllegalAccessError.class)
    public void checkIllegalAccess() throws Exception {
        limitedClass.myField = 1;
    }

    @Test(groups = "fast")
    @Privileged
    public void checkGrantedAccess() throws Exception {
        limitedClass.myField = 1;
        assertThat(limitedClass.myField).isEqualTo(1);
    }

    @Test(groups = "fast")
    public void checkProperSynchronization() throws Exception {
        Thread t1 = new Thread(this::addValue);
        Thread t2 = new Thread(this::addValue);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        assertThat(limitedClass.synchronizedField).isEqualTo(2000000);
    }

    void addValue(){
        int max = 1000000;
        for (int x=0; x<max; x++) {
            limitedClass.synchronizedField++;
        }
    }
}

class LimitedClass {
    @LimitedAccess
    public int myField;
    @SynchronizedAccess
    int synchronizedField;
    volatile int volatileField;
}