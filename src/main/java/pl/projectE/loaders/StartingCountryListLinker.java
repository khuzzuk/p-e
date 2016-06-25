package pl.projectE.loaders;

import com.sun.istack.internal.Nullable;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StartingCountryListLinker implements FileLinker {
    @Override
    @Nullable
    public Path getResource() {
        try {
            return Paths.get(this.getClass().getResource("/countryList.dat").toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}
