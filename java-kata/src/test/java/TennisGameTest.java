import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

@Disabled
public class TennisGameTest {
    private String playerNameA = "Bob";
    private String playerNameB = "Rob";

    private TennisGame candidate = new TennisGame(playerNameA, playerNameB);

    @Test
    void new_game() {
        String result = candidate.score();

        assertThat(result, is("Love all"));
    }

    @Test
    void love_all_for_nothing() {
        candidate.round(0, 0);

        String result = candidate.score();

        assertThat(result, is("Love all"));
    }

    @Test
    void begin_new_game() {
        candidate.newGame();

        candidate.round(1, 1);

        candidate.newGame();

        String result = candidate.score();

        assertThat(result, is("Love all"));
    }

    @Test
    void advantage_player() {
        candidate.newGame();

        candidate.round(4, 3);

        String result = candidate.score();

        assertThat(result, is("Advantage " + playerNameA));

        candidate.round(4, 5);

        result = candidate.score();

        assertThat(result, is("Advantage " + playerNameB));
    }

    @Test
    void game_player() {
        candidate.newGame();

        candidate.round(6, 4);

        String result = candidate.score();

        assertThat(result, is("Game " + playerNameA));

        candidate.round(4, 6);

        result = candidate.score();

        assertThat(result, is("Game " + playerNameB));

        candidate.round(2, 4);

        result = candidate.score();

        assertThat(result, is("Game " + playerNameB));
    }

    @Test
    void same_scores() {
        candidate.newGame();

        candidate.round(1, 1);

        String result = candidate.score();

        assertThat(result, is("Fifteen all"));

        candidate.round(2, 2);

        result = candidate.score();

        assertThat(result, is("Thirty all"));

        candidate.round(3, 3);

        result = candidate.score();

        assertThat(result, is("Deuce"));
    }

    @ParameterizedTest
    @CsvSource({ "0,0,Love all", "1,1,Fifteen all", "2,2,Thirty all", "3,3,Deuce", "4,3,Advantage Bob",
            "4,5,Advantage Rob", "4,6,Game Rob", "6,4,Game Bob", "0,1,Love Fifteen", "1,2,Fifteen Thirty",
            "4,2,Game Bob" })
    void testTable(int scoreA, int scoreB, String result) {
        candidate.round(scoreA, scoreB);

        result = candidate.score();

        assertThat(result, is(result));
    }
}
