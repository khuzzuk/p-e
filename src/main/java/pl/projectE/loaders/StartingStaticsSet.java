package pl.projectE.loaders;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StartingStaticsSet implements FileSet {
    @Override
    public BufferedReader getReader() {
        return new BufferedReader(new InputStreamReader(StartingStaticsSet.class.getResourceAsStream("/countryList.dat")));
    }
}
