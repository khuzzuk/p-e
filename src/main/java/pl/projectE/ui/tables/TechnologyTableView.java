package pl.projectE.ui.tables;

import javafx.scene.control.TableView;
import pl.projectE.model.Country;
import pl.projectE.ui.ColumnFactory;

import static pl.projectE.ui.ValueFormatter.CURRENCY_PRECISE;

public class TechnologyTableView extends TableView<Country> implements ColumnFactory {
    public TechnologyTableView() {
        getColumns().addAll(getColumnWithString("country", c -> c.name),
                getColumn("Natural Res", CURRENCY_PRECISE, c -> c.technology.techNaturalResources),
                getColumn("Biomedics", CURRENCY_PRECISE, c -> c.technology.techBiomedics),
                getColumn("Engineering", CURRENCY_PRECISE, c -> c.technology.techEngineering),
                getColumn("Computer Science", CURRENCY_PRECISE, c -> c.technology.techComputers),
                getColumn("Mathematics/Economy", CURRENCY_PRECISE, c -> c.technology.techMathematicsEconomy),
                getColumn("Physics", CURRENCY_PRECISE, c -> c.technology.techPhysics),
                getColumn("Social sciences", CURRENCY_PRECISE, c -> c.technology.techSocialSciences),
                getColumn("Military", CURRENCY_PRECISE, c -> c.technology.techMilitary),
                getColumn("Humanities", CURRENCY_PRECISE, c -> c.technology.techHumanities),
                getColumn("Linguistics", CURRENCY_PRECISE, c -> c.technology.techForeignLanguages),
                getColumn("Artistry", CURRENCY_PRECISE, c -> c.technology.techArtistry)
        );
    }
}
