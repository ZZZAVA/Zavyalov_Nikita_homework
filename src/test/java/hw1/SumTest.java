package hw1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SumTest extends BeforeTest {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "sumLTest", groups = "sumSub")
    public void sumLongTest(Long a, Long b, Long res) {
        Assert.assertEquals(calc.sum(a, b), res);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "sumDTest", groups = "sumSub")
    public void sumDoubleTest(double a, double b, double res) {
        Assert.assertEquals(calc.sum(a, b), res);
    }

}
