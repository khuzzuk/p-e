package pl.projectE.math;

import pl.projectE.model.Country;

public class RefreshFacade {
    public static void refreshCountry(Country country) {
        PopulationCalculations.refreshPopulation(country);
        MarketCalculations.actualProductionRefresh(country);
    }
}
