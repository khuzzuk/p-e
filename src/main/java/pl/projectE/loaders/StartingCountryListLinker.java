package pl.projectE.loaders;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Log4j2
public class StartingCountryListLinker implements FileLinker {
    @Getter
    private String path = "/countryList.dat";
}
