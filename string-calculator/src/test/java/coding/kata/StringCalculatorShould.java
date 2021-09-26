package coding.kata;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import sun.awt.geom.AreaOp;

@RunWith(JUnit4.class)
public class StringCalculatorShould {

    @Test
    public void return_0_when_empty_string_is_provided() {
        StringCalculator calculator = new StringCalculator();
        Assert.assertEquals(calculator.calculate(""), 0);
    }

    @Test
    public void return_1_when_1_is_provided_as_string() {
        StringCalculator calculator = new StringCalculator();
        Assert.assertEquals(calculator.calculate("1"), 1);
    }
}