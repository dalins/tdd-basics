package social;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.layout.BorderPane;

public class TimelineView extends BorderPane {
    public TimelineView(Timeline timeline) {
        intializeView(timeline);
    }

    private void intializeView(Timeline timeline) {
        ListView<String> postingList = new ListView<>(timeline.getItems());
        postingList.setId("postingsList");
        setCenter(postingList);
    }
}
