package hw1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MultTest extends BeforeTest {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "multLTest", groups = "multDiv")
    public void multiLongTest(long a, long b, long res) {
        Assert.assertEquals(calc.mult(a, b), res);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "multDTest", groups = "multDiv")
    public void multiDoubleTest(double a, double b, double res) {
        Assert.assertEquals(calc.mult(a, b), res);
    }

}
