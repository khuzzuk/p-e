package pl.projectE.ui.tables;

import javafx.scene.control.TableView;
import pl.projectE.model.Country;
import pl.projectE.ui.ColumnFactory;

import static pl.projectE.ui.ValueFormatter.PRECISE;

public class TechnologyTableView extends TableView<Country> implements ColumnFactory<Country> {
    public TechnologyTableView() {
        getColumns().addAll(getColumnWithString("country", c -> c.name),
                getColumn("Natural Res", PRECISE, c -> c.technology.techNaturalResources),
                getColumn("Biomedics", PRECISE, c -> c.technology.techBiomedics),
                getColumn("Engineering", PRECISE, c -> c.technology.techEngineering),
                getColumn("Computer Science", PRECISE, c -> c.technology.techComputers),
                getColumn("Mathematics/Economy", PRECISE, c -> c.technology.techMathematicsEconomy),
                getColumn("Physics", PRECISE, c -> c.technology.techPhysics),
                getColumn("Social sciences", PRECISE, c -> c.technology.techSocialSciences),
                getColumn("Military", PRECISE, c -> c.technology.techMilitary),
                getColumn("Humanities", PRECISE, c -> c.technology.techHumanities),
                getColumn("Linguistics", PRECISE, c -> c.technology.techForeignLanguages),
                getColumn("Artistry", PRECISE, c -> c.technology.techArtistry)
        );
    }
}
