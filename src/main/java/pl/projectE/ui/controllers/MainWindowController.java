package pl.projectE.ui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.util.Pair;
import lombok.NonNull;
import pl.projectE.model.Country;
import pl.projectE.model.Scenario;
import pl.projectE.ui.Cleaning;
import pl.projectE.ui.CountryData;
import pl.projectE.ui.tables.*;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.*;

import static pl.projectE.App.bus;
import static pl.projectE.ui.Cleaning.Type.COMBO_BOX;
import static pl.projectE.ui.Cleaning.Type.TABLE_VIEW;

public class MainWindowController extends Formatted {
    @Cleaning(type = TABLE_VIEW)
    @CountryData
    public AssetsTableView assets;
    @Cleaning(type = TABLE_VIEW)
    @CountryData
    public TaxTableView taxes;
    @Cleaning(type = TABLE_VIEW)
    @CountryData
    public RevenuesTableView revenues;
    @Cleaning(type = TABLE_VIEW)
    @CountryData
    public MacroIndicatorsTableView macroIndicators;
    @Cleaning(type = TABLE_VIEW)
    @CountryData
    public LandTableView infrastructure;
    @Cleaning(type = TABLE_VIEW)
    @CountryData
    public CivilSecurityTableView civilSecurity;
    @Cleaning(type = TABLE_VIEW)
    @CountryData
    public HealthCareTableView healthCare;
    @Cleaning(type = TABLE_VIEW)
    @CountryData
    public SocialIndicatorsTableView socialIndicators;
    @Cleaning(type = TABLE_VIEW)
    @CountryData
    public TechnologyTableView technology;
    @Cleaning(type = TABLE_VIEW)
    @CountryData
    public ResourcesTableView resources;

    @Cleaning(type = TABLE_VIEW)
    @CountryData
    public EnergyTableView energy;
    @Cleaning(type = TABLE_VIEW)
    @CountryData
    public EducationTableView education;
    @Cleaning(type = TABLE_VIEW)
    @CountryData
    public PensionsTableView pensions;
    @Cleaning(type = TABLE_VIEW)
    @CountryData
    public EmploymentTableView employment;
    @Cleaning(type = TABLE_VIEW)
    @CountryData
    public AdministrationTableView administration;
    @Cleaning(type = TABLE_VIEW)
    @CountryData
    public MilitaryTableView military;
    @Cleaning(type = TABLE_VIEW)
    public PopulationTableView population;
    @Cleaning(type = TABLE_VIEW)
    public ProductsTableView products;
    @Cleaning(type = COMBO_BOX)
    public ComboBox<String> countriesList;
    public Map<Class<? extends Formatted>, ? extends Formatted> controllers;
    public Tab taxTab;
    public Tab populationTab;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.initialize(location, resources);
        bus.setGuiReaction("scenario.show", this::loadScenario);
        bus.<Country>setGuiReaction("scenario.show.country",
                country -> controllers.values().forEach(value -> value.showCountry(country)));
    }

    public void get2010Scenario() {
        clear();
        bus.sendCommunicate("scenario.loader.load.2010", "scenario.show");
    }

    private void loadScenario(@NonNull Scenario scenario) {
        countriesList.getItems().addAll(scenario.countries.keySet());
        Collection<Country> countriesData = scenario.countries.values();
        Arrays.stream(fields)
                .filter(f -> f.isAnnotationPresent(CountryData.class))
                .forEach(f -> fillCountryData(f, countriesData));
    }

    private void fillCountryData(Field field, Collection<Country> countryData) {
        try {
            ((TableView<Country>) field.get(this)).getItems().addAll(countryData);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void loadCountry() {
        Optional.ofNullable(countriesList.getSelectionModel().getSelectedItem())
                .ifPresent(selectedItem -> bus.send("scenario.load.country",
                        "scenario.show.country",
                        selectedItem));
    }

    public void showCountry(Country country) {
        population.getItems().clear();
        products.getItems().clear();
        for (int x = 0; x < country.population.pyramid.length; x++) {
            population.getItems().add(new Pair<>(x, country.population.pyramid[x]));
        }
        products.getItems().addAll(country.products);
    }
}
