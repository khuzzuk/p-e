package pl.projectE.ui.tables;

import javafx.scene.control.TableView;
import pl.projectE.model.Country;
import pl.projectE.ui.ColumnFactory;

import static pl.projectE.ui.ValueFormatter.*;

public class MacroIndicatorsTableView extends TableView<Country> implements ColumnFactory {
    public MacroIndicatorsTableView() {
        getColumns().addAll(getColumnWithString("Country", c -> c.name),
                getColumn("GDP", CURRENCY, c -> c.macroIndicators.gdp),
                getColumn("inflation", PERCENT, c -> c.macroIndicators.inflation),
                getColumn("salary", CURRENCY_PRECISE, c -> c.macroIndicators.averageSalary),
                getColumn("net wages", CURRENCY, c -> c.macroIndicators.netWages),
                getColumn("investments", CURRENCY, c -> c.macroIndicators.investments),
                getColumn("cci", PERCENT, c -> c.macroIndicators.cci),
                getColumn("debt int. rate", PERCENT, c -> c.macroIndicators.debtInterestRate));
    }
}
