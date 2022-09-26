package hw1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SubTest extends BeforeTest {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "subLTest", groups = "sumSub")
    public void subLongTest(long a, long b, long res) {
        Assert.assertEquals(calc.sub(a, b), res);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "subDTest", groups = "sumSub")
    public void subDoubleTest(double a, double b, double res) {
        Assert.assertEquals(calc.sub(a, b), res);
    }

}
