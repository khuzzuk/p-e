package pl.projectE.cache;

import org.apache.commons.collections4.map.MultiKeyMap;
import org.testng.annotations.Test;
import pl.projectE.inject.Component;
import pl.projectE.inject.qualifiers.*;

import javax.inject.Inject;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CacheInitializerTest {
    @Test(groups = "integration")
    public void checkCacheInitializing() throws Exception {
        new CacheInitializer();
        ComponentsTracker componentsTracker = new ComponentsTracker();
        assertThat(componentsTracker.variablesKeys).isNotNull();
        assertThat(componentsTracker.countriesNames.size()).isGreaterThan(50);
    }
    @Component
    private class ComponentsTracker {
        @Inject
        @CacheElement
        @KeyElements
        @Variables
        private MultiKeyMap<Object, String> variablesKeys;
        @Inject
        @CountriesNames
        private List<String> countriesNames;
    }
}