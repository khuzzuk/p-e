package pl.projectE.loaders;

import pl.projectE.model.Scenario;

public class ScenarioLoaderManager {
    public Scenario loadScenario() {
        return loadScenario(ScenarioLinkers.SCENARIO2010);
    }
    private Scenario loadScenario(FileLinker scenarioLinker){
        ScenarioLoader loader = new ScenarioLoader(new ScenarioToArrayLoader(scenarioLinker),
                new ListLinker("/countryList.dat"), new ListLinker("/productsNames.dat"));
        return loader.loadScenario();
    }
}
