package pl.projectE.model;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CountriesManagerTest {
    @Test(groups = "integration")
    public void checkPostConstructMethod() throws Exception {
        CountriesManager manager = new CountriesManager();
        assertNotNull(manager.loader);
        assertEquals(manager.countries.size(), 54);
    }
}