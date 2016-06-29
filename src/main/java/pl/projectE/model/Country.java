package pl.projectE.model;

import java.util.Map;

public class Country {
    static Map<Country, Object> countries;

    private String name;

    public Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
