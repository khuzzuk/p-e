package pl.projectE.loaders;

import pl.projectE.inject.Component;

import javax.inject.Named;

@Component
public class ScenarioLoaderManager {
    @Component
    @Named("scenarioToLoad")
    public FileLinker loadScenario(){
        return ScenarioLinkers.SCENARIO2010;
    }
}
