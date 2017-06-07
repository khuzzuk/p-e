package pl.projectE.loaders;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Log4j2
public class CountriesNamesLoader {

    private List<String> countries;
    @NonNull
    private FileLinker fileLinker;

    List<String> loadResource() {
        if (countries == null) {
            try {
                countries = fileLinker.readAllLines();
            } catch (IOException e) {
                log.error("cannot read file {}", fileLinker);
                log.error(e);
            }
        }
        return countries;
    }
}
