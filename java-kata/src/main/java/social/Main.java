package social;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    private Map<Users, Timeline> userTimelines = new HashMap<>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        createUserStream().forEach(user -> userTimelines.put(user, new Timeline()));

        primaryStage.setScene(createScene());

        primaryStage.show();
    }

    private Scene createScene() {
        TabPane timelineTabPane = new TabPane();
        ObservableList<Tab> tabs = timelineTabPane.getTabs();

        ComboBox<Users> userSelect = new ComboBox<>();
        userSelect.setId("userSelect");
        createUserStream().forEach(userSelect.getItems()::add);
        userSelect.getSelectionModel().selectedItemProperty().addListener((source, oldVal, newVal) -> handleUserLogin(newVal, tabs));
        userSelect.setValue(Users.ALICE);

        BorderPane pane = new BorderPane();
        pane.setTop(userSelect);
        pane.setCenter(timelineTabPane);

        return new Scene(pane);
    }

    private void handleUserLogin(Users loggedInUser, ObservableList<Tab> tabs) {
        tabs.clear();

        addPersonalTimeLineTo(loggedInUser, tabs);
    }

    private void addPersonalTimeLineTo(Users loggedInUser, ObservableList<Tab> tabs) {
        Tab tab = new Tab("Timeline " + loggedInUser);
        tab.setId("timeline" + loggedInUser);
        tab.setContent(new PersonalTimelineView(getTimelineOf(loggedInUser), loggedInUser));

        tabs.add(tab);
    }

    private Timeline getTimelineOf(Users loggedInUser) {
        return userTimelines.get(loggedInUser);
    }

    private Stream<Users> createUserStream() {
        return Stream.of(Users.values());
    }
}
