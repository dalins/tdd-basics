
package social;

import javafx.scene.control.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.layout.BorderPane;

public class TimelineView extends Tab {

    private final Timeline timeline;
    private final Users user;

    public TimelineView(Timeline timeline, Users user) {
        this.timeline = timeline;
        this.user = user;

        TextField inputField = new TextField();
        inputField.setId("input");

        Button button = new Button("Enter text");
        button.setId("enterTextButton");
        button.setOnAction(e -> timeline.post(inputField.getText()));

        BorderPane pain = new BorderPane();
        pain.setTop(new Label("Das ist die famose Timeline von ... " + user.name()));
        pain.setCenter(inputField);

        HBox hbox = new HBox(inputField, button);
        pain.setBottom(hbox);

        ListView<String> timelineData = new ListView<>(this.timeline.list);
        timelineData.setId("timeline");
        pain.setCenter(timelineData);

        this.setContent(pain);
    }

}
