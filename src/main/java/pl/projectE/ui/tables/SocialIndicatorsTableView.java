package pl.projectE.ui.tables;

import javafx.scene.control.TableView;
import pl.projectE.model.Country;
import pl.projectE.ui.ColumnFactory;

import static pl.projectE.ui.ValueFormatter.CURRENCY;

public class SocialIndicatorsTableView extends TableView<Country> implements ColumnFactory {
    public SocialIndicatorsTableView() {
        getColumns().addAll(getColumnWithString("country", c -> c.name),
                getColumn("educatedPopulation", CURRENCY, c -> c.socialIndicators.educatedPopulation),
                getColumn("familyValues", CURRENCY, c -> c.socialIndicators.familyValues),
                getColumn("familyAllowancesPerChild", CURRENCY, c -> c.socialIndicators.familyAllowancesPerChild)
        );
    }
}
