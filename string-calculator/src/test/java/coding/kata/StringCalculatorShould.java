package coding.kata;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(JUnit4.class)
public class StringCalculatorShould {

    private StringCalculator calculator;

    @Before
    public void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    public void return_0_when_empty_string_is_provided() {
        assertEquals(calculator.add(""), 0);
    }

    @Test
    public void return_1_when_1_is_provided_as_string() {
        assertEquals(calculator.add("1"), 1);
    }

    @Test
    public void return_2_when_2_is_provided_as_string() {
        assertEquals(calculator.add("2"), 2);
    }

    @Test
    public void return_2_when_1_comma_1_is_provided_as_string() {
        assertEquals(calculator.add("1,1"), 2);
    }

    @Test
    public void return_3_when_1_comma_2_is_provided_as_string() {
        assertEquals(calculator.add("1,2"), 3);
    }

    @Test
    public void return_3_when_1_comma_1_comma_1_is_provided_as_string() {
        assertEquals(calculator.add("1,1,1"), 3);
    }

    @Test
    public void return_3_when_1_new_line_2_is_provided_as_string() {
        assertEquals(calculator.add("1\n2"), 3);
    }

    @Test
    public void return_3_when_1_new_line_1_comma_1_is_provided_as_string() {
        assertEquals(calculator.add("1\n1,1"), 3);
    }

    @Test
    public void return_3_using_the_new_delimiter_semicolon_when_1_semicolon_2_is_provided_as_string() {
        assertEquals(calculator.add("//;\n1;2"), 3);
    }

    @Test
    public void return_3_using_the_new_delimiter_TTT_when_1_TTT_2_is_provided_as_string() {
        assertEquals(calculator.add("//TTT\n1TTT2"), 3);
    }

    @Test
    public void throw_an_exception_when_a_negative_value_is_added() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    calculator.add("1,-2");
                });
        assertEquals("negatives not allowed -2", exception.getMessage());
    }

    @Test
    public void throw_an_exception_when_two_negative_values_are_added() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    calculator.add("-1,-2");
                });
        assertEquals("negatives not allowed -1 -2", exception.getMessage());
    }
}