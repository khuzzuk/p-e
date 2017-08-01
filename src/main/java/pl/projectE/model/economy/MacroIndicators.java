package pl.projectE.model.economy;

import pl.projectE.math.DataType;
import pl.projectE.model.Refresh;
import pl.projectE.ui.ValueFormatter;

@Refresh(sequence = 2)
public class MacroIndicators {

    @DataType(type = ValueFormatter.PERCENT)
    public int inflation;

    @DataType(type = ValueFormatter.PERCENT)
    public int debtInterestRate;

    @DataType(type = ValueFormatter.BIG)
    public long averageSalary;

    @DataType(type = ValueFormatter.SIMPLE)
    public int cci;

    @DataType(type = ValueFormatter.BIG)
    public long gdp;

    @DataType(type = ValueFormatter.BIG)
    public long investments;

    @DataType(type = ValueFormatter.BIG)
    public long netWages;

    @DataType(type = ValueFormatter.BIG)
    public transient long gdpIn$;

    @DataType(type = ValueFormatter.SIMPLE)
    public transient long gdpPerCapita;

    @DataType(type = ValueFormatter.SIMPLE)
    public transient int gdpPerCapita$;

    @DataType(type = ValueFormatter.PERCENT)
    public transient int propensityToConsume;
}
