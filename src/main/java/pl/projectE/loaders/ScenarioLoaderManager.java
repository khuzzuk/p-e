package pl.projectE.loaders;

import pl.projectE.model.Country;

import java.util.Map;
import java.util.SortedMap;

public class ScenarioLoaderManager {
    public Map<String, Country> loadScenario() {
        return loadScenario(ScenarioLinkers.SCENARIO2010);
    }
    private SortedMap<String, Country> loadScenario(FileLinker scenarioLinker){
        ScenarioLoader loader = new ScenarioLoader(new ScenarioToArrayLoader(scenarioLinker),
                new ListLinker("/countryList.dat"), new ListLinker("/productsNames.dat"));
        loader.loadScenario();
        return loader.countries;
    }
}
