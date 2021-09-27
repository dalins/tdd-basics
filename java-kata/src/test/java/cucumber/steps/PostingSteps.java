package cucumber.steps;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.isNotNull;

import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.control.ComboBoxMatchers;
import org.testfx.service.query.NodeQuery;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import social.Main;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class PostingSteps extends TestFxSteps {
    @Before
    public void setUpClass() throws Exception {
        ApplicationTest.launch(Main.class);
    }

    @When("{string} publishes {string}")
    public void alice_publishes_a_message(String user, String message) {
        ComboBox<String> query = lookup("#userSelect").query();
        assertThat(query, ComboBoxMatchers.containsItems(user));

        clickOn("#userSelect");
        type(KeyCode.DOWN);
        type(KeyCode.ENTER);

        assertThat(query, ComboBoxMatchers.hasSelectedItem(user));

        clickOn("#input");
        write(message);

        clickOn("#enterTextButton");
    }

    @Then("{string} is added to {string} timeline")
    public void the_message_is_added_to_alice_timeline(String message, String user) {
        ListView<String> timeline = lookup("#timeline").query();

        ObservableList<String> items = timeline.getItems();
        
        assertThat(items, is(not(empty())));
        assertThat(items.get(items.size() - 1), is(message));
    }
}
