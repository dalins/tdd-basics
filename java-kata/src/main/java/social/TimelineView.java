package social;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.layout.BorderPane;

public class TimelineView extends Tab {
    public TimelineView(Timeline timeline, Users user) {
        intializeView(timeline, user);
    }

    private void intializeView(Timeline timeline, Users user) {
        initializeProperties(user);

        TextField inputField = new TextField();
        inputField.setId("input");

        Button button = new Button("Enter text");
        button.setId("enterTextButton");
        button.setOnAction(e -> timeline.post(inputField.getText()));

        BorderPane pain = new BorderPane();
        pain.setCenter(inputField);

        HBox hbox = new HBox(inputField, button);
        pain.setBottom(hbox);

        ListView<String> timelineData = new ListView<>(timeline.getItems());
        timelineData.setId("timeline");
        pain.setCenter(timelineData);

        this.setContent(pain);
    }

    private void initializeProperties(Users user) {
        setText(user.name());
        setClosable(false);
    }

}
