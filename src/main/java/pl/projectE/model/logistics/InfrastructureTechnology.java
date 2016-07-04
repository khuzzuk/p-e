package pl.projectE.model.logistics;

import pl.projectE.sec.LimitedAccess;

public class InfrastructureTechnology {
    @LimitedAccess
    public int roads;
    @LimitedAccess
    public int highways;
    @LimitedAccess
    public int Railways;
    @LimitedAccess
    public int Airports;
    @LimitedAccess
    public int Docks;
    @LimitedAccess
    public int Vehicles;
}
