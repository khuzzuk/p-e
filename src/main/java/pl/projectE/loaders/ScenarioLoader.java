package pl.projectE.loaders;

import pl.projectE.inject.Component;
import pl.projectE.sec.LimitedAccess;

import javax.inject.Inject;
import javax.inject.Named;

@Component
public class ScenarioLoader {
    @Inject
    @Named("scenarioToLoad")
    private FileLinker scenario;


}
