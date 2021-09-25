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
    public void return_zero_when_empty_string_is_provided() {
        StringCalculator calculator = new StringCalculator();
        Assert.assertEquals(calculator.calculate(""), 0);
    }
}