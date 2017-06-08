import javafx.util.Pair;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ConditionalPriorityTripleKeyMap<K1, K2, K3, V> {
    private MultiValuedMap<K1, K3> predicatedValues;
    @Getter
    private Map<K1, MultiValuedMap<K2, V>> groupedValues;
    private Map<Pair<K1, K3>, Pair<K2, V>> filteredValues;
    private BiFunction<V, V, Boolean> predicate;
    public static <K1, K2, K3, V> ConditionalPriorityTripleKeyMap<K1, K2, K3, V> create(BiFunction<V, V, Boolean> predicate) {
        return new ConditionalPriorityTripleKeyMap<>(new ArrayListValuedHashMap<>(),
                new HashMap<>(),
                new HashMap<>(),
                predicate);
    }

    public boolean conditionalPut(K1 key1, K2 key2, K3 key3, V value) {
        if (predicatedValues.containsMapping(key1, key3)) {
            Pair<K1, K3> multiKey = new Pair<>(key1, key3);
            Pair<K2, V> oldValue = filteredValues.get(multiKey);
            if (predicate.apply(oldValue.getValue(), value)) {
                groupedValues.get(key1).removeMapping(key2, oldValue.getValue());
                groupedValues.get(key1).put(key2, value);
            } else {
                return false;
            }
        } else {
            predicatedValues.put(key1, key3);
            ArrayListValuedHashMap<K2, V> groupedEntry = new ArrayListValuedHashMap<>();
            groupedEntry.put(key2, value);
            groupedValues.put(key1, groupedEntry);
        }
        return true;
    }
}
