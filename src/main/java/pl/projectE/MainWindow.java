package pl.projectE;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import pl.projectE.ui.CentralScreen;
import pl.projectE.ui.MainContainer;

public class MainWindow extends Application implements MainContainer, CentralScreen {
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage primaryStage) throws Exception {
        Rectangle2D screen = Screen.getPrimary().getVisualBounds();
        AnchorPane pane = new AnchorPane();
        Scene scene = new Scene(pane, screen.getWidth(), screen.getHeight(), CentralScreen.BACKGROUND_COLOR);
        addBasicButtons(pane);
        addCentralRing(pane);
        addButton(pane, 90, 105, Color.ALICEBLUE);
        primaryStage.setIconified(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
