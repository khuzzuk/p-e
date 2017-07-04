package pl.projectE.ui.tables;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Pair;
import pl.projectE.model.Country;
import pl.projectE.ui.ColumnFactory;


public class PopulationTableView extends TableView<Pair<Integer, Integer>> implements ColumnFactory<Country> {
    public PopulationTableView() {
        TableColumn<Pair<Integer, Integer>, String> age = new TableColumn<>("age");
        age.setCellValueFactory(p ->
                new SimpleStringProperty(p.getValue().getKey().toString()));
        TableColumn<Pair<Integer, Integer>, String> pop = new TableColumn<>("totalPopulation");
        pop.setCellValueFactory(p ->
                new SimpleStringProperty(p.getValue().getValue().toString()));

        getColumns().add(age);
        getColumns().add(pop);
    }
}
