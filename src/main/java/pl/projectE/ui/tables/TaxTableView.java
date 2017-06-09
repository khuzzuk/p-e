package pl.projectE.ui.tables;

import javafx.scene.control.TableView;
import pl.projectE.model.Country;
import pl.projectE.ui.ColumnFactory;

import java.text.DecimalFormat;

import static pl.projectE.ui.ValueFormatter.PERCENT;

public class TaxTableView extends TableView<Country> implements ColumnFactory {
    public TaxTableView() {
        getColumns().addAll(getColumnWithString("Country", c -> c.name),
                getColumn("low tax", PERCENT, c -> c.taxPolicy.pitLowMargin),
                getColumn("med tax", PERCENT, c -> c.taxPolicy.pitMediumMargin),
                getColumn("high tax", PERCENT, c -> c.taxPolicy.pitHighMargin),
                getColumn("low margin", PERCENT, c -> c.taxPolicy.pitLowMarginThreshold),
                getColumn("med margin", PERCENT, c -> c.taxPolicy.pitMediumMarginThreshold),
                getColumn("payroll", PERCENT, c -> c.taxPolicy.payroll),
                getColumn("cit", PERCENT, c -> c.taxPolicy.cit),
                getColumn("redundancy", PERCENT, c -> c.taxPolicy.redundancy),
                getColumn("vat", PERCENT, c -> c.taxPolicy.vat),
                getColumn("sales", PERCENT, c -> c.taxPolicy.sales),
                getColumn("tariff", PERCENT, c -> c.taxPolicy.tariff),
                getColumn("land ownership", PERCENT, c -> c.taxPolicy.fromLandOwnership),
                getColumn("improvements to land", PERCENT, c -> c.taxPolicy.improvementsToLand),
                getColumn("movables", PERCENT, c -> c.taxPolicy.movableProperty),
                getColumn("inheritance", PERCENT, c -> c.taxPolicy.inheritance),
                getColumn("capital gains", PERCENT, c -> c.taxPolicy.capitalGains),
                getColumn("transactions", PERCENT, c -> c.taxPolicy.financialTransactions),
                getColumn("tolls", PERCENT, c -> c.taxPolicy.tolls),
                getColumn("crime fees", PERCENT, c -> c.taxPolicy.crimeFees),
                getColumnWithBoolean("gov employees", c -> c.taxPolicy.governmentEmployee),
                getColumnWithBoolean("gov benefactors", c -> c.taxPolicy.governmentBenefactors));
    }
}
