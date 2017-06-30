package pl.projectE.loaders;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CountriesNamesImplementationTest {

    @Test(groups = "integration")
    public void checkLoadingLines() throws Exception {
        EnumeratedNamesLoader loader = new EnumeratedNamesLoader(ScenarioLinkers.SCENARIO2010);
        List<String> strings = loader.loadResource();
        int numberOfCountries = 54;
        Assert.assertEquals(strings.size(), numberOfCountries);
    }
}