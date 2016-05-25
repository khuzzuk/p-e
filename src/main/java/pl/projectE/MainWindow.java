package pl.projectE;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import pl.projectE.ui.CentralScreen;
import pl.projectE.ui.CirclePane;
import pl.projectE.ui.annot.BasicContainer;

@SuppressWarnings("restriction")
@BasicContainer
public class MainWindow extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage primaryStage) throws Exception {
        primaryStage.initStyle(StageStyle.UNDECORATED);
    	AnchorPane pane = setupPane();
        Scene scene = setupScene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private Scene setupScene(AnchorPane pane){
        Rectangle2D screen = Screen.getPrimary().getVisualBounds();
        Scene scene = new Scene(pane, screen.getWidth(), screen.getHeight());
        CirclePane circlePane = new CirclePane(pane);
        circlePane.addButton(90, 105, Color.GRAY);
        return scene;
    }
    private AnchorPane setupPane(){
    	AnchorPane pane = new AnchorPane();
        pane.setBackground(new Background(new BackgroundFill(CentralScreen.BACKGROUND_COLOR,null,null)));
    	return pane;
    }
}
