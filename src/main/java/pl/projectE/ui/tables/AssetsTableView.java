package pl.projectE.ui.tables;

import javafx.scene.control.TableView;
import pl.projectE.model.Country;
import pl.projectE.ui.ColumnFactory;

import static pl.projectE.ui.ValueFormatter.CURRENCY;


public class AssetsTableView extends TableView<Country> implements ColumnFactory {
    public AssetsTableView() {
        getColumns().addAll(getColumnWithString("Country", c -> c.name),
                getColumn("M0", CURRENCY, c -> c.assets.m0),
                getColumn("national debt", CURRENCY, c -> c.assets.nationalDebt),
                getColumn("stock market", CURRENCY, c -> c.assets.stockMarketValue),
                getColumn("assets private", CURRENCY, c -> c.assets.assetsPrivate),
                getColumn("assets corporate", CURRENCY, c -> c.assets.assetsCorporate),
                getColumn("pension net cap.", CURRENCY, c -> c.assets.pensionNetCapital),
                getColumn("interest rates", CURRENCY, c -> c.assets.interestRates)
                );
    }
}
