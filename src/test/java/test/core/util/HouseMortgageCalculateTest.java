package test.core.util;

import com.core.util.HouseMortgageCalculate;
import org.junit.Test;

/**
 * Created by giozola on 2017/8/3.
 */
public class HouseMortgageCalculateTest {
    @Test
    public void housecaculate(){
        HouseMortgageCalculate cal = new HouseMortgageCalculate((double)100000,0.049,120);
        System.out.println(cal.getAllMoney());
    }
}
