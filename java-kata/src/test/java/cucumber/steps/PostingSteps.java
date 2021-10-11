package cucumber.steps;

import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.control.ComboBoxMatchers;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import social.Main;
import social.Users;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class PostingSteps extends TestFxSteps {
    @Before
    public void setUpClass() throws Exception {
        ApplicationTest.launch(Main.class);
    }

    @When("{string} publishes {string}")
    public void alice_publishes_a_message(String user, String message) {
        clickOn("#userSelect");
        clickOn("BOB");

        clickOn("#input");
        write(message);

        clickOn("#enterTextButton");
    }

    @Then("{string} is added to {string} timeline")
    public void the_message_is_added_to_alice_timeline(String message, String user) {
        ListView<String> timeline = lookup("#timeline").query();

        ObservableList<String> items = timeline.getItems();
        
        assertThat("Last timeline entry", items, is(not(empty())));
        assertThat("Last timeline entry", lastItem(items), is(message));
    }

    private String lastItem(ObservableList<String> items) {
        return items.get(items.size() - 1);
    }
}
