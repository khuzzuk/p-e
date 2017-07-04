package pl.projectE.loaders;

import pl.projectE.model.Scenario;

public class ScenarioLoaderManager {
    public Scenario loadScenario() {
        return loadScenario(ScenarioLinkers.SCENARIO2010);
    }
    private Scenario loadScenario(FileLinker scenarioLinker){
        ScenarioLoader loader = new ScenarioLoader(new DataToArrayLoader(scenarioLinker),
                new ListLinker("/countryList.dat"),
                new ListLinker("/productsNames.dat"),
                new ListLinker("/ProdMatrix.csv"));
        return loader.loadScenario();
    }
}
