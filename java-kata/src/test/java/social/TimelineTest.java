package social;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.Collections;

public class TimelineTest {
    @Test
    void publishes_his_items() {
        var timeline = new Timeline();

        ObservableList<String> items = timeline.getItems();

        assertThat(items, is(equalTo(Collections.emptyList())));
    }

    @Test
    void addition_of_posts() {
        var timeline = new Timeline();

        timeline.post("This is my first post. Hello twitter. ;) #fckafd");
    }
}
