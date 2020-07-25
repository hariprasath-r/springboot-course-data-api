package in.hp.java.boot.testing;

import org.junit.Assert;
import org.junit.Test;

public class SomeBusinessImplTest {


    @Test
    public void calculateSum() {
        SomeBusinessImpl someBusiness = new SomeBusinessImpl();
        int actualResult = someBusiness.calculateSum(new int[]{1, 2, 3, 4, 5});
        int expectedResult = 15;
        Assert.assertEquals(expectedResult, actualResult);
    }
}