package pl.projectE;

import javafx.application.Application;
import javafx.stage.Stage;
import pl.khuzzuk.messaging.Bus;
import pl.projectE.cache.CountriesCache;
import pl.projectE.loaders.ScenarioLoaderManager;
import pl.projectE.ui.MainWindowStage;

public class App extends Application {
    public static Bus bus;
    private static ScenarioLoaderManager scenarioLoaderManager;

    public static void main(String[] args) {
        bus = Bus.initializeBus(false);
        scenarioLoaderManager = new ScenarioLoaderManager();
        bus.setResponse("scenario.loader.load.2010", () -> scenarioLoaderManager.loadScenario());
        CountriesCache.init();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainWindowStage stage = new MainWindowStage();
        stage.init(primaryStage);
    }
}
