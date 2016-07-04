package pl.projectE.cache;

import it.unimi.dsi.fastutil.objects.Object2LongMap;
import it.unimi.dsi.fastutil.objects.Object2LongOpenHashMap;
import jdk.nashorn.internal.ir.annotations.Immutable;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import pl.projectE.inject.AlwaysNew;
import pl.projectE.inject.Component;
import pl.projectE.inject.qualifiers.*;
import pl.projectE.model.Variable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Component
public class GovernmentFundsCache implements Cache<Variable, String> {
    @Inject
    @Implementation(specifiedClass = Object2LongOpenHashMap.class)
    @AlwaysNew
    private Object2LongMap<EntryKey> cache;

    @Inject
    @CacheElement
    @KeyElements
    @Variables
    @Implementation(specifiedClass = ArrayListValuedHashMap.class)
    private MultiKeyMap<Object, EntryKey> allKeys;

    @Inject
    @Implementation(specifiedClass = ArrayList.class)
    @Named("countriesNamesList")
    @CountriesNames
    private List<String> countriesNames;

    @PostConstruct
    void generateKeys() {
        Variable[] variables = Variable.values();
        for (Variable v : variables) {
            for (String country : countriesNames) {
                allKeys.put(v, country, new EntryKey(country, v));
            }
        }
    }

    public int size() {
        return cache.size();
    }

    public long get(Variable variable, String countryName) {
        return cache.get(allKeys.get(countryName, variable));
    }


    @Immutable
    class EntryKey {
        private final String countryName;
        private final Variable variable;

        EntryKey(String countryName, Variable variable) {
            this.countryName = countryName;
            this.variable = variable;
        }

        @Override
        public int hashCode() {
            return variable.ordinal() * 31 + countryName.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            EntryKey entryKey = (EntryKey) o;

            return countryName.equals(entryKey.countryName) && variable == entryKey.variable;
        }
    }
}
