package social;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.layout.BorderPane;

public class PersonalTimelineView extends BorderPane {
    public PersonalTimelineView(Timeline timeline, Users user) {
        intializeView(timeline, user);
    }

    private void intializeView(Timeline timeline, Users user) {
        initializeProperties(user);

        TextField inputField = new TextField();
        inputField.setId("input");

        Button button = new Button("Enter text");
        button.setId("enterTextButton");
        button.setOnAction(e -> timeline.post(inputField.getText()));

        setCenter(inputField);

        HBox hbox = new HBox(inputField, button);
        setBottom(hbox);

        setCenter(new TimelineView(timeline));
    }

    private void initializeProperties(Users user) {
        setId("personaltimeline" + user.name());
    }

}
