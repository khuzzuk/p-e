package pl.projectE.loaders;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ScenarioLoaderTest {
    private List<String> mockedCountriesNames;
    private ScenarioLoader scenarioLoader;

    @BeforeMethod
    public void setUp() throws Exception {
        putScenarioFileToContainer();
        scenarioLoader = new ScenarioLoader(new ScenarioToArrayLoader(ScenarioLinkers.SCENARIO2010),
                new CountriesNamesLoader(new StartingCountryListLinker()));
    }

    @Test(groups = "integration")
    public void loadGameTest() throws Exception {
        scenarioLoader.loadScenario();
        assertThat(scenarioLoader.countries).isNotNull();
    }

    private FileLinker putScenarioFileToContainer(){
        return ScenarioLinkers.SCENARIO2010;
    }
}