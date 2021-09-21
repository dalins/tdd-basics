package social;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setScene(createScene());

        primaryStage.show();
    }

    private Scene createScene()
    {
        Label timeline = new Label();
        timeline.setId("timeline");

        Button button = new Button("Enter text");
        button.setId("enterTextButton");

        BorderPane pane = new BorderPane();
        pane.setCenter(timeline);
        pane.setBottom(button);
        Scene scene = new Scene(pane);
        return scene;
    }
}
