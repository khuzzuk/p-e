package pl.projectE.loaders;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

@Log4j2
@RequiredArgsConstructor
enum ScenarioLinkers implements FileLinker {
    SCENARIO2010("/scen2010.csv");

    @Getter
    private final String path;
}
