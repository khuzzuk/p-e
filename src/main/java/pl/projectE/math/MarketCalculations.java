package pl.projectE.math;

import pl.projectE.model.Country;
import pl.projectE.model.production.Product;

public class MarketCalculations {
    public static void actualProductionRefresh(Country country) {
        for (Product p : country.products) {
            p.actualProduction = p.employed * p.endProductivity;
        }
    }
}
