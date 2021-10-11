import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

public class BowlingGameTest{

    BowlingGame game ;

    @BeforeEach
    void setup()
    {
        game = new BowlingGame();
    }

    @Test
    void test_initial_score()
    {
         assertThat(game.score(), is(0));
    }

    @Test
    void test_one_roll_score()
    {
        game.roll(7);
        assertThat(game.score(), is(7));
    }

    @Test
    void test_illegal_input()
    {
        game.roll(7);

        assertThrows(IllegalArgumentException.class, () -> game.roll(4));
    }

    @Test
    void test_add_pins_for_frames()
    {
        game.roll(3);
        game.roll(0);
        game.roll(10);
        assertThat(game.score(), is(13));
    }

    
}