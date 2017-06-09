package pl.projectE.ui.tables;

import javafx.scene.control.TableView;
import pl.projectE.model.Country;
import pl.projectE.ui.ColumnFactory;

import static pl.projectE.ui.ValueFormatter.CURRENCY;

public class RevenuesTableView extends TableView<Country> implements ColumnFactory {
    public RevenuesTableView() {
        getColumns().addAll(getColumnWithString("Country", c -> c.name),
                getColumn("total receipits", CURRENCY, c -> c.governmentFinances.totalReceipts));
    }
}
