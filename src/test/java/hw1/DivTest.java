package hw1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DivTest extends BeforeTest {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "divLTest", groups = "multDiv")
    public void divLongTest(long a, long b, long res) {
        Assert.assertEquals(calc.div(a, b), res);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "divDTest", groups = "multDiv")
    public void divDoubleTest(double a, double b, double res) {
        Assert.assertEquals(calc.div(a, b), res);
    }

}
