package social;

import java.util.stream.Stream;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(createScene());

        primaryStage.show();
    }

    private Scene createScene() {
        var timeline = new Timeline();

        TabPane timelineTabPane = new TabPane();
        ObservableList<Tab> tabs = timelineTabPane.getTabs();
        Stream.of(Users.values()).map(user -> createTimelineTabFor(user, timeline)).forEach(tabs::add);

        TextField inputField = new TextField();
        inputField.setId("input");

        Button button = new Button("Enter text");
        button.setId("enterTextButton");
        button.setOnAction(e -> timeline.post(inputField.getText()));

        ComboBox<String> userSelect = new ComboBox<>();
        userSelect.getItems().add("Alice");
        userSelect.setId("userSelect");

        BorderPane pane = new BorderPane();
        pane.setTop(userSelect);
        pane.setCenter(timelineTabPane);

        HBox postingBox = new HBox();
        postingBox.getChildren().addAll(inputField, button);
        pane.setBottom(postingBox);

        return new Scene(pane);
    }

    // ich hatte hier schon zu viel gemacht :(

    Tab createTimelineTabFor(Users user, Timeline timeline) {
        ListView<String> timelineListView = new ListView<>();
        timelineListView.setItems(timeline.getItems());
        timelineListView.setId("timeline");

        Tab tab = new Tab();
        tab.setContent(timelineListView);

        return tab;
    }
}
