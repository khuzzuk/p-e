package pl.projectE.cache;

import lombok.experimental.UtilityClass;
import pl.projectE.App;
import pl.projectE.model.Country;

import java.util.Map;
import java.util.SortedMap;

@UtilityClass
public class CountriesCache {
    public static SortedMap<String, Country> countries;
    public void init() {
        App.bus.<SortedMap<String, Country>>setReaction("scenario.show", map -> countries = map);
        App.bus.<String, Country>setResponse("scenario.load.country", name -> countries.get(name));
    }
}
