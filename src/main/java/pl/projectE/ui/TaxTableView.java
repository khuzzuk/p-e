package pl.projectE.ui;

import javafx.scene.control.TableView;
import pl.projectE.model.Country;

import java.text.DecimalFormat;

public class TaxTableView extends TableView<Country> implements ColumnFactory {
    public TaxTableView() {
        getColumns().addAll(getColumnWithString("Country", c -> c.name),
                getColumnWithInt("low tax", 10, "%", c -> c.taxPolicy.pitLowMargin),
                getColumnWithInt("med tax", 10, "%", c -> c.taxPolicy.pitMediumMargin),
                getColumnWithInt("high tax", 10, "%", c -> c.taxPolicy.pitHighMargin),
                getColumnWithInt("low margin", 10, "%", c -> c.taxPolicy.pitLowMarginThreshold),
                getColumnWithInt("med margin", 10, "%", c -> c.taxPolicy.pitMediumMarginThreshold),
                getColumnWithInt("payroll", 10, "%", c -> c.taxPolicy.payroll),
                getColumnWithInt("cit", 10, "%", c -> c.taxPolicy.cit),
                getColumnWithInt("redundancy", 10, "%", c -> c.taxPolicy.redundancy),
                getColumnWithInt("vat", 10, "%", c -> c.taxPolicy.vat),
                getColumnWithInt("sales", 10, "%", c -> c.taxPolicy.sales),
                getColumnWithInt("tariff", 10, "%", c -> c.taxPolicy.tariff),
                getColumnWithInt("land ownership", 10, "%", c -> c.taxPolicy.fromLandOwnership),
                getColumnWithInt("improvements to land", 10, "%", c -> c.taxPolicy.improvementsToLand),
                getColumnWithInt("movables", 10, "%", c -> c.taxPolicy.movableProperty),
                getColumnWithInt("inheritance", 10, "%", c -> c.taxPolicy.inheritance),
                getColumnWithInt("capital gains", 10, "%", c -> c.taxPolicy.capitalGains),
                getColumnWithInt("transactions", 10, "%", c -> c.taxPolicy.financialTransactions),
                getColumnWithInt("tolls", 10, "%", c -> c.taxPolicy.tolls),
                getColumnWithInt("crime fees", 10, "%", c -> c.taxPolicy.crimeFees),
                getColumnWithBoolean("gov employees", c -> c.taxPolicy.governmentEmployee),
                getColumnWithBoolean("gov benefactors", c -> c.taxPolicy.governmentBenefactors));
    }
}
