package pl.projectE.loaders;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameStaticsLoaderTest {
    private final int numberOfCountries = 54;
    @Mock
    private FileSet fileSet;

    @BeforeMethod(groups = "integration")
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test(groups = "integration")
    public void checkLoadingLines() throws Exception {
        GameStaticsLoader loader = new GameStaticsLoader();
        //loader.setFileSet(fileSet);
        List<String> strings = loader.loadCountries();
        assertThat(strings.size()).isEqualTo(numberOfCountries);
    }
}