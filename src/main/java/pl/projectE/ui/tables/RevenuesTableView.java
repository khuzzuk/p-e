package pl.projectE.ui.tables;

import javafx.scene.control.TableView;
import pl.projectE.model.Country;
import pl.projectE.ui.ColumnFactory;

import static pl.projectE.ui.ValueFormatter.BIG;

public class RevenuesTableView extends TableView<Country> implements ColumnFactory<Country> {
    public RevenuesTableView() {
        getColumns().addAll(getColumnWithString("Country", c -> c.name),
                getColumn("total receipits", BIG, c -> c.governmentFinances.totalReceipts));
    }
}
