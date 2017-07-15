package pl.projectE.ui.tables;

import javafx.scene.control.TableView;
import pl.projectE.model.production.Product;
import pl.projectE.ui.ColumnFactory;

import java.util.stream.Collectors;

import static pl.projectE.ui.ValueFormatter.*;

public class ProductsTableView extends TableView<Product> implements ColumnFactory<Product> {
    public ProductsTableView() {
        getColumns().addAll(getColumnWithString("Name", c -> c.name),
                getColumn("price", PRECISE, c -> c.price),
                getColumn("employed", SIMPLE, c -> c.employed),
                getColumn("actual prod.", SIMPLE, c -> c.actualProduction),
                getColumn("ind. eff.", PRECISE, c -> c.industrialProductivity),
                getColumn("act. tech.", PRECISE, c -> c.actualTech),
                getColumn("assets", BIG, c -> c.assets),
                getColumn("end productivity", PRECISE, c -> c.endProductivity),
                getColumnWithString("resources", c ->
                    c.resources.object2IntEntrySet().stream()
                            .map(e -> e.getKey().name + "=" + e.getIntValue())
                            .collect(Collectors.joining("; "))
                )
        );
    }
}
