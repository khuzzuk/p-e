package pl.projectE.model;

import org.testng.annotations.Test;
import pl.projectE.sec.Privileged;

import static org.testng.Assert.*;

public class CountriesManagerTest {
    @Test(groups = "integration")
    @Privileged
    public void checkPostConstructMethod() throws Exception {
        CountriesManager manager = new CountriesManager();
        assertNotNull(manager.loader);
        assertEquals(manager.countries.size(), 54);
    }
}