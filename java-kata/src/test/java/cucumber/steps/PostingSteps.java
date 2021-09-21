package cucumber.steps;

import static org.junit.jupiter.api.Assertions.fail;

import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.service.query.NodeQuery;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import javafx.scene.control.Label;
import social.Main;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

public class PostingSteps extends TestFxSteps {
    @Before
    public void setUpClass() throws Exception {
        ApplicationTest.launch(Main.class);
    }

    @When("Alice publishes a Message")
    public void alice_publishes_a_message() {
        clickOn("#enterTextButton");
    }

    @Then("the Message is added to Alice timeline")
    public void the_message_is_added_to_alice_timeline() {
        Label timeline = lookup("#timeline").query();

        assertThat(timeline.getText(), is("test"));
    }
}
