package social;

import java.util.stream.Stream;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(createScene());

        primaryStage.show();
    }

    private Scene createScene() {
        var timeline = new Timeline();

        ComboBox<Users> userSelect = new ComboBox<>();
        userSelect.setId("userSelect");
        createUserStream().forEach(userSelect.getItems()::add);
        userSelect.setValue(Users.ALICE);

        TabPane timelineTabPane = new TabPane();
        ObservableList<Tab> tabs = timelineTabPane.getTabs();
        createUserStream().map(user -> new TimelineView(timeline, user))
                          .forEach(tabs::add);


        BorderPane pane = new BorderPane();
        pane.setTop(userSelect);
        pane.setCenter(timelineTabPane);

        return new Scene(pane);
    }

    private Stream<Users> createUserStream() {
        return Stream.of(Users.values());
    }
}
