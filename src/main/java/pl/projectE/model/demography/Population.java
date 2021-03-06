package pl.projectE.model.demography;

import pl.projectE.math.DataType;
import pl.projectE.model.Refresh;

import static pl.projectE.ui.ValueFormatter.BIG_DOWNGRADED;
import static pl.projectE.ui.ValueFormatter.PERCENT;

@Refresh(sequence = 1)
public class Population {
    @DataType(type = BIG_DOWNGRADED)
    public int[] pyramid = new int[121];

    @DataType(type = BIG_DOWNGRADED)
    public transient int totalPopulation;

    @DataType(type = BIG_DOWNGRADED)
    public transient int laborForce;

    @DataType(type = BIG_DOWNGRADED)
    public transient int retired;

    @DataType(type = BIG_DOWNGRADED)
    public transient int underWorkingAge;

    @DataType(type = PERCENT)
    public transient int nonLaborForceRatio;

    @DataType(type = BIG_DOWNGRADED)
    public transient int activeWorkForce;

    @DataType(type = PERCENT)
    public transient int popPerSqKm;
}
