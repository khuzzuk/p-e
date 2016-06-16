package pl.projectE.loaders;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.projectE.sec.Privileged;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class GameStaticsLoaderTest {
    private final int numberOfCountries = 2;
    @Mock
    private FileSet fileSet;
    @Mock
    BufferedReader reader;

    private List<String> list;

    @BeforeMethod(groups = "fast")
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        list = new ArrayList<>();
        list.add("USA");
        list.add("Canada");
        when(fileSet.getReader()).thenReturn(reader);
        when(reader.lines()).thenReturn(list.stream());
    }

    @Test(groups = "fast")
    @Privileged
    public void checkLoadingLines() throws Exception {
        GameStaticsLoader loader = new GameStaticsLoader();
        loader.fileSet = fileSet;
        List<String> strings = loader.loadCountries();
        assertThat(strings.size()).isEqualTo(numberOfCountries);
    }
}