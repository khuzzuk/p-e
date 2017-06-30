package pl.projectE.loaders;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Log4j2
public class EnumeratedNamesLoader {

    private List<String> names;
    private final FileLinker fileLinker;

    List<String> loadResource() {
        if (names == null) {
            try {
                names = fileLinker.readAllLines();
            } catch (IOException e) {
                log.error("cannot read file {}", fileLinker);
                log.error(e);
            }
        }
        return names;
    }
}
