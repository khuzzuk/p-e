package pl.projectE.cache;

import lombok.Setter;
import pl.projectE.App;
import pl.projectE.model.Country;
import pl.projectE.model.Scenario;

public class CountriesCache {
    @Setter
    private static Scenario scenario;
    public static void init() {
        App.bus.setReaction("scenario.show", CountriesCache::setScenario);
        App.bus.<String, Country>setResponse("scenario.load.country", name -> scenario.countries.get(name));
    }
}
