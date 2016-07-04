package pl.projectE.model.economy;

import pl.projectE.sec.LimitedAccess;

public class Assets {
    @LimitedAccess
    public long pensionNetCapital;
    @LimitedAccess
    public long nationalDebt;
    @LimitedAccess
    public long assetsPrivate;
    @LimitedAccess
    public long assetsCorporate;
    @LimitedAccess
    public long stockMarketValue;
    @LimitedAccess
    public long m0;
}
