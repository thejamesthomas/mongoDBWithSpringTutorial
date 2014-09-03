package app;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps;
import lombok.EqualsAndHashCode;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import static com.google.common.collect.Maps.newHashMap;
import static com.google.common.collect.Sets.newHashSet;

@EqualsAndHashCode
public class Person implements Map {

    public static final String ID = "_id";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String EYE_COLOR = "eyeColor";
    public static final String WEARS_GLASSES = "wearsGlasses";
    public static final String DOMINANT_HAND = "dominantHand";

    public Set keys = newHashSet(ID, FIRST_NAME, LAST_NAME, EYE_COLOR, WEARS_GLASSES, DOMINANT_HAND);
    public Map data = newHashMap();

    public Person(String id, String firstName, String lastName) {
        data.put(ID, id);
        data.put(FIRST_NAME, firstName);
        data.put(LAST_NAME, lastName);
    }

    public String getFirstName() {
        return String.valueOf(data.get(FIRST_NAME));
    }

    public String getLastName() {
        return String.valueOf(data.get(LAST_NAME));
    }

    public Person(Map data) {
        putAll(data);
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return data.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return data.containsValue(value);
    }

    @Override
    public Object get(Object key) {
        return data.get(key);
    }

    @Override
    public Object put(Object key, Object value) {
        return data.put(key, value);
    }

    @Override
    public Object remove(Object key) {
        return data.remove(key);
    }

    @Override
    public void putAll(Map data) {
        Map filteredMap = Maps.filterKeys(data, new Predicate() {
            @Override
            public boolean apply(Object o) {
                return keys.contains(o);
            }
        });
        this.data.putAll(filteredMap);
    }

    @Override
    public void clear() {
        data.clear();
    }

    @Override
    public Set keySet() {
        return keys;
    }

    @Override
    public Collection values() {
        return data.values();
    }

    @Override
    public Set<Entry> entrySet() {
        return data.entrySet();
    }
}
