package pl.projectE.loaders;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;


enum ScenarioLinkers implements FileLinker {
    SCENARIO2010("/scen2010.csv");

    private final String scenarioFileName;

    ScenarioLinkers(String s) {
        scenarioFileName = s;
    }

    @Override
    public Path getResource() {
        try {
            return Paths.get(getClass().getResource(scenarioFileName).toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}
