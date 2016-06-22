package pl.projectE.loaders;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameStaticsLoader {

    private List<String> countries;

    private FileSet fileSet;

    public GameStaticsLoader(FileSet fileSet) {
        this.fileSet = fileSet;
    }

    public List<String> loadCountries(){
        if (countries==null) {
            countries = loadResource(fileSet!=null ? fileSet : new StartingStaticsSet());
        }
        return countries;
    }

    private List<String> loadResource(FileSet fileSet) {
        List<String> countries = new ArrayList<>();
        try (BufferedReader reader = fileSet.getReader()) {
            countries = reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countries;
    }
}
