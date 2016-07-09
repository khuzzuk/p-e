package pl.projectE.model;

import pl.projectE.model.economy.Assets;
import pl.projectE.model.economy.MacroIndicators;
import pl.projectE.model.government.Military;
import pl.projectE.model.government.GovernmentFinances;
import pl.projectE.model.land.ImprovementsToLand;
import pl.projectE.model.land.Infrastructure;
import pl.projectE.model.land.InfrastructureTechnology;
import pl.projectE.model.social.CivilSecurity;
import pl.projectE.model.social.HealthCare;
import pl.projectE.model.social.SocialIndicators;
import pl.projectE.model.social.Technology;
import pl.projectE.sec.LimitedAccess;

public class Country {
    public final String name;

    @LimitedAccess
    public Assets assets;
    @LimitedAccess
    public MacroIndicators macroIndicators;
    @LimitedAccess
    public Military military;
    @LimitedAccess
    public ImprovementsToLand improvementsToLand;
    @LimitedAccess
    public Infrastructure infrastructure;
    @LimitedAccess
    public InfrastructureTechnology infrastructureTechnology;
    @LimitedAccess
    public CivilSecurity civilSecurity;
    @LimitedAccess
    public HealthCare healthCare;
    @LimitedAccess
    public SocialIndicators socialIndicators;
    @LimitedAccess
    public Technology technology;
    @LimitedAccess
    public GovernmentFinances governmentFinances;

    public Country(String name) {
        this.name = name;
    }
}
