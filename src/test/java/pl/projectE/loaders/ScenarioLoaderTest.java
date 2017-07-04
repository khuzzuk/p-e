package pl.projectE.loaders;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.projectE.model.Scenario;

import java.util.List;

public class ScenarioLoaderTest {
    private List<String> mockedCountriesNames;
    private ScenarioLoader scenarioLoader;

    @BeforeMethod
    public void setUp() throws Exception {
        putScenarioFileToContainer();
        scenarioLoader = new ScenarioLoader(new DataToArrayLoader(ScenarioLinkers.SCENARIO2010),
                new ListLinker("/countryList.dat"),
                new ListLinker("/productsNames.dat"),
                new ListLinker("ProdMatrix.csv"));
    }

    @Test(groups = "integration")
    public void loadGameTest() throws Exception {
        Scenario scenario = scenarioLoader.loadScenario();
        Assert.assertNotNull(scenario);
    }

    private FileLinker putScenarioFileToContainer(){
        return ScenarioLinkers.SCENARIO2010;
    }
}