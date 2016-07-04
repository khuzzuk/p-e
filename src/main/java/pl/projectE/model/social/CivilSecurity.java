package pl.projectE.model.social;

import pl.projectE.sec.LimitedAccess;

public class CivilSecurity {
    @LimitedAccess
    public int corruption;
    @LimitedAccess
    public int crimeRate;
    @LimitedAccess
    public int imprisonedPopulation;
    @LimitedAccess
    public long policeEquipmentCapital;
}
