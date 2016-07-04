package pl.projectE.model;

import pl.projectE.model.economy.Assets;
import pl.projectE.model.economy.MacroIndicators;
import pl.projectE.model.economy.WealthIndicators;
import pl.projectE.model.government.Military;
import pl.projectE.model.government.TaxPolicy;
import pl.projectE.model.land.ImprovementsToLand;
import pl.projectE.model.logistics.Infrastructure;
import pl.projectE.model.logistics.InfrastructureTechnology;
import pl.projectE.model.social.CivilSecurity;
import pl.projectE.model.social.HealthCare;
import pl.projectE.model.social.SocialIndicators;
import pl.projectE.model.social.Technology;

public class Country {
    public final String name;

    private Assets assets;
    private MacroIndicators macroIndicators;
    private WealthIndicators wealthIndicators;
    private Military military;
    private TaxPolicy taxPolicy;
    private ImprovementsToLand improvementsToLand;
    private Infrastructure infrastructure;
    private InfrastructureTechnology infrastructureTechnology;
    private CivilSecurity civilSecurity;
    private HealthCare healthCare;
    private SocialIndicators socialIndicators;
    private Technology technology;

    public Country(String name) {
        this.name = name;
    }

    public void setAssets(Assets assets) {
        this.assets = assets;
    }
}
