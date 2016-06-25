package pl.projectE.inject;

import org.testng.annotations.Test;
import pl.projectE.loaders.CountriesNamesLoader;
import pl.projectE.model.Country;

import static org.testng.Assert.*;

public class InjectorTest {
    @Test(groups = "fast")
    public void checkInjectionForComponent() throws Exception {
        Country country = new Country("");
        System.out.println(Country.loader);
    }
}