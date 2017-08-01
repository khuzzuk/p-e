package pl.projectE.model.government;

import pl.projectE.math.DataType;
import pl.projectE.ui.ValueFormatter;

public class Administration {
    @DataType(type = ValueFormatter.PERCENT)
    public int officialsProjectedRate;
    @DataType(type = ValueFormatter.PERCENT)
    public int officialsSalary;
    public Laws laws;
    public Justice justice;

    @DataType(type = ValueFormatter.PRECISE)
    public transient long officialsSalaryTotal;
    @DataType(type = ValueFormatter.SIMPLE)
    public transient int officialsTotal;
    @DataType(type = ValueFormatter.BIG)
    public transient long spending;
    @DataType(type = ValueFormatter.PRECISE)
    public transient int administrationCost;
}
