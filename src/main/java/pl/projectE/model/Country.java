package pl.projectE.model;

import java.util.Map;

class Country {
    static Map<Country, Object> countries;

    private final String name;

    Country(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}
