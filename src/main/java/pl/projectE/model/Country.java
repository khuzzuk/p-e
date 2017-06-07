package pl.projectE.model;

import lombok.RequiredArgsConstructor;
import pl.projectE.model.economy.Assets;
import pl.projectE.model.economy.MacroIndicators;
import pl.projectE.model.government.GovernmentFinances;
import pl.projectE.model.government.Military;
import pl.projectE.model.government.TaxPolicy;
import pl.projectE.model.land.ImprovementsToLand;
import pl.projectE.model.land.Infrastructure;
import pl.projectE.model.land.InfrastructureTechnology;
import pl.projectE.model.social.CivilSecurity;
import pl.projectE.model.social.HealthCare;
import pl.projectE.model.social.SocialIndicators;
import pl.projectE.model.social.Technology;

@RequiredArgsConstructor
public class Country {
    public final String name;
    public Assets assets;
    public MacroIndicators macroIndicators;
    public Military military;
    public ImprovementsToLand improvementsToLand;
    public Infrastructure infrastructure;
    public InfrastructureTechnology infrastructureTechnology;
    public CivilSecurity civilSecurity;
    public HealthCare healthCare;
    public SocialIndicators socialIndicators;
    public Technology technology;
    public GovernmentFinances governmentFinances;
    public TaxPolicy taxPolicy;
}
