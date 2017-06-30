package pl.projectE.ui.tables;

import javafx.scene.control.TableView;
import pl.projectE.model.Country;
import pl.projectE.ui.ColumnFactory;

import static pl.projectE.ui.ValueFormatter.BIG;


public class AssetsTableView extends TableView<Country> implements ColumnFactory<Country> {
    public AssetsTableView() {
        getColumns().addAll(getColumnWithString("Country", c -> c.name),
                getColumn("M0", BIG, c -> c.assets.m0),
                getColumn("national debt", BIG, c -> c.assets.nationalDebt),
                getColumn("stock market", BIG, c -> c.assets.stockMarketValue),
                getColumn("assets private", BIG, c -> c.assets.assetsPrivate),
                getColumn("assets corporate", BIG, c -> c.assets.assetsCorporate),
                getColumn("pension net cap.", BIG, c -> c.assets.pensionNetCapital),
                getColumn("interest rates", BIG, c -> c.assets.interestRates)
                );
    }
}
