package pl.projectE.model.land;

import pl.projectE.sec.LimitedAccess;

public class Infrastructure {
    @LimitedAccess
    public int roads;
    @LimitedAccess
    public int highways;
    @LimitedAccess
    public int railways;
    @LimitedAccess
    public int airports;
    @LimitedAccess
    public int docks;
    @LimitedAccess
    public int vehicles;
}
