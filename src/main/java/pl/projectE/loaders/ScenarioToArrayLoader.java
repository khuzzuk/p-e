package pl.projectE.loaders;

import pl.projectE.inject.Component;
import pl.projectE.inject.qualifiers.Scenario;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

@Component
@Scenario
public class ScenarioToArrayLoader {

    @Inject
    @Named("scenarioToLoad")
    private FileLinker scenario;
    private String[][] data;

    public String[][] loadResource() {
        if (data== null)
            data = loadFile();
        return data;
    }

    private String[][] loadFile() {
        String[][] tempData = null;
        try {
            List<String> rawData = loadRawData();
            tempData = new String[rawData.size()][];
            for (int x=0; x<tempData.length; x++) {
                tempData[x] = rawData.get(x).split(";");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tempData;
    }

    private List<String> loadRawData() throws IOException {
        return Files.readAllLines(scenario.getResource(), StandardCharsets.UTF_8);
    }
}
