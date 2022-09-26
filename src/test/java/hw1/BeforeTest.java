package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeGroups;


public class BeforeTest {

    protected static Calculator calc;

    @BeforeGroups(groups = {"multDiv", "sumSub"})
    public void initCalculator() {
        calc = new Calculator();
    }
}
