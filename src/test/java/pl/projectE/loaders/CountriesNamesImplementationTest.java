package pl.projectE.loaders;

import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CountriesNamesImplementationTest {

    @Test(groups = "integration")
    public void checkLoadingLines() throws Exception {
        CountriesNamesLoader loader = new CountriesNamesLoader();
        List<String> strings = loader.loadResource();
        int numberOfCountries = 54;
        assertThat(strings.size()).isEqualTo(numberOfCountries);
    }
}