package pl.projectE.loaders;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public interface FileLinker {
    String getPath();
    default List<String> readAllLines() throws IOException {
        try {
            URI uri = FileLinker.class.getResource(getPath()).toURI();
            return Files.readAllLines(Paths.get(uri));
        } catch (URISyntaxException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return Collections.emptyList();
    }
}
