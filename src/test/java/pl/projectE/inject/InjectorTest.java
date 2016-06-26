package pl.projectE.inject;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.projectE.model.CountriesManager;

public class InjectorTest {
    @Test(groups = "fast")
    public void checkInjectionForComponent() throws Exception {
        CountriesManager manager = new CountriesManager();
        Assert.assertNotNull(manager.loader);
    }
}