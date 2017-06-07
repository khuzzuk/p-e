package pl.projectE.loaders;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

@RequiredArgsConstructor
public class ScenarioToArrayLoader {
    @NonNull
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
            List<String> rawData = scenario.readAllLines();
            tempData = new String[rawData.size()][];
            for (int x=0; x<tempData.length; x++) {
                tempData[x] = rawData.get(x).split(";");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tempData;
    }
}
