package pl.projectE.ui.tables;

import javafx.scene.control.TableView;
import pl.projectE.model.Country;
import pl.projectE.ui.ColumnFactory;

import static pl.projectE.ui.ValueFormatter.BIG;

public class SocialIndicatorsTableView extends TableView<Country> implements ColumnFactory<Country> {
    public SocialIndicatorsTableView() {
        getColumns().addAll(getColumnWithString("country", c -> c.name),
                getColumn("educatedPopulation", BIG, c -> c.socialIndicators.educatedPopulation),
                getColumn("familyValues", BIG, c -> c.socialIndicators.familyValues),
                getColumn("familyAllowancesPerChild", BIG, c -> c.socialIndicators.familyAllowancesPerChild)
        );
    }
}
