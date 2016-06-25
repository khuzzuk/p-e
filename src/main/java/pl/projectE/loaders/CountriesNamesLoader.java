package pl.projectE.loaders;

import pl.projectE.inject.Component;
import pl.projectE.inject.qualifiers.CountriesNames;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Component
@CountriesNames
public class CountriesNamesLoader implements ResourceLoader {

    private List<String> countries;

    private FileLinker fileLinker;

    public CountriesNamesLoader() {}

    public void setFileLinker(FileLinker fileLinker) {
        this.fileLinker = fileLinker;
    }

    @Override
    public List<String> loadResource(){
        if (countries==null) {
            countries = loadResource(fileLinker !=null ? fileLinker : new StartingCountryListLinker());
        }
        return countries;
    }

    private List<String> loadResource(FileLinker fileLinker) {
        List<String> countries = new ArrayList<>();
        try {
            countries = Files.readAllLines(fileLinker.getResource(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countries;
    }
}
