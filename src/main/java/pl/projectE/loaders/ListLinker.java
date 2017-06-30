package pl.projectE.loaders;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
public class ListLinker implements FileLinker {
    @Getter
    private final String path;
}
