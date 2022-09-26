package hw1;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "sumLTest")
    public static Object[][] sumLongData() {
        return new Object[][]{{2L, 3L, 5L}, {6L, 3L, 9L}};
    }

    @DataProvider(name = "sumDTest")
    public static Object[][] sumDoubleData() {
        return new Object[][]{{4.0, 2.8, 6.8}, {11.2, 2.8, 14.0}};
    }

    @DataProvider(name = "multLTest")
    public static Object[][] multiLongData() {
        return new Object[][]{{5L, 3L, 15L}, {2L, 2L, 4L}};
    }

    @DataProvider(name = "multDTest")
    public static Object[][] multiDoubleData() {
        return new Object[][]{{3.1, 1.5, 4.}, {2.2, 2.2, 4.}};
    }

    @DataProvider(name = "subLTest")
    public static Object[][] subLongData() {
        return new Object[][]{{3L, 2L, 1L}, {12L, 6L, 6L}};
    }

    @DataProvider(name = "subDTest")
    public static Object[][] subDoubleData() {
        return new Object[][]{{10.2, 5.6, 4.6}, {5.5, 2.5, 3.}};
    }

    @DataProvider(name = "divLTest")
    public static Object[][] divLongData() {
        return new Object[][]{{10L, 2L, 5L}, {20L, 5L, 4L}};
    }

    @DataProvider(name = "divDTest")
    public static Object[][] divDoubleData() {
        return new Object[][]{{17.64, 4.2, 4.2}, {11.28, 1.2, 9.4}};
    }
}
