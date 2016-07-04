package pl.projectE.loaders;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.projectE.inject.Component;
import pl.projectE.inject.qualifiers.CountriesNames;
import pl.projectE.inject.qualifiers.Scenario;

import javax.inject.Named;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ScenarioLoaderTest {
    private List<String> mockedCountriesNames;
    private ScenarioLoader scenarioLoader;

    @BeforeMethod

    public void setUp() throws Exception {
        putScenarioFileToContainer();
        scenarioLoader = new ScenarioLoader();
    }

    @Test(groups = "integration")
    public void loadGameTest() throws Exception {
        scenarioLoader.loadScenario();
        assertThat(scenarioLoader.getCountries()).isNotNull();
    }

    @Component
    @Named("scenarioToLoad")
    private FileLinker putScenarioFileToContainer(){
        return ScenarioLinkers.SCENARIO2010;
    }

    @Component
    @Scenario
    private ScenarioToArrayLoader putMockedLoaderToContainer(final ScenarioToArrayLoader mockedLoader) {
        return mockedLoader;
    }

    @Component
    @CountriesNames
    private CountriesNamesLoader putMockedCountriesNamesLoaderToContainer(CountriesNamesLoader countriesNamesLoader) {
        return countriesNamesLoader;
    }
}