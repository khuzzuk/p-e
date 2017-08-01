package pl.projectE.math;

import pl.projectE.model.Country;

public class HealthCareCalculations {
    public static int HEALTH_CARE_COST_TABLE_NUMBER;
    static int healthCareCost(Country country) {
        return country.products[HEALTH_CARE_COST_TABLE_NUMBER].price;
    }
}
