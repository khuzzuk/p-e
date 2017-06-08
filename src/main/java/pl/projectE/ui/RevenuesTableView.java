package pl.projectE.ui;

import javafx.scene.control.TableView;
import pl.projectE.model.Country;

public class RevenuesTableView extends TableView<Country> implements ColumnFactory {
    public RevenuesTableView() {
        getColumns().addAll(getColumnWithString("Country", c -> c.name),
                getColumnWithLong("total receipits", 1_000_000, "mln", c -> c.governmentFinances.totalReceipts));
    }
}
