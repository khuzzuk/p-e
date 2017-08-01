package pl.projectE.model.economy;

import pl.projectE.math.DataType;
import pl.projectE.ui.ValueFormatter;

public class Assets {
    @DataType(type = ValueFormatter.BIG)
    public long pensionNetCapital;

    @DataType(type = ValueFormatter.BIG)
    public long nationalDebt;

    @DataType(type = ValueFormatter.BIG)
    public long assetsPrivate;

    @DataType(type = ValueFormatter.BIG)
    public long assetsCorporate;

    @DataType(type = ValueFormatter.BIG)
    public long stockMarketValue;

    @DataType(type = ValueFormatter.BIG)
    public long m0;

    @DataType(type = ValueFormatter.PERCENT)
    public int interestRates;
}
