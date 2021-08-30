import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

public class StringCalculatorTest {
    private StringCalculator candidate = new StringCalculator();

    @Test
    void should_return_zero_for_empty_string(){
        int result = candidate.calculate("");

        assertThat(result, is(0));
    }

    @Test
    void should_return_number_for_string(){
        int result = candidate.calculate("1");

        assertThat(result, is(1));
    }

    @Test
    void should_return_number_for_other_string(){
        int result = candidate.calculate("10");

        assertThat(result, is(10));
    }

    @Test
    void should_return_sum_for_comma_delimited_values(){
        int result = candidate.calculate("10,20");

        assertThat(result, is(30));
    }

    @Test
    void should_return_sum_for_new_line_delimited_values(){
        int result = candidate.calculate("120\n2");

        assertThat(result, is(122));
    }

    @Test
    void should_return_sum_for_multi_delimited_values(){
        int result = candidate.calculate("120\n2,7");

        assertThat(result, is(129));
    }

    @Test
    void should_fail_on_negative_numbers(){
        assertThrows(IllegalArgumentException.class, () -> candidate.calculate("120\n-2,7"));
    }

    @Test
    void should_ignore_values_greater_1000(){
        int result = candidate.calculate("10,100\n1000,1010");

        assertThat(result, is(1110));
    }
}
