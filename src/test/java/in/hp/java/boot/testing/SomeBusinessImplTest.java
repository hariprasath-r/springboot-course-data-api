package in.hp.java.boot.testing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SomeBusinessImplTest {

    private SomeBusinessImpl someBusiness;

    @Before
    public void initialize() {
        this.someBusiness = new SomeBusinessImpl();
    }

    @Test
    public void calculateSum() {
        int actualResult = someBusiness.calculateSum(new int[]{1, 2, 3, 4, 5});
        int expectedResult = 15;
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSum_withOneValue() {
        int actualResult = someBusiness.calculateSum(new int[]{1});
        int expectedResult = 1;
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSum_withNoValue() {
        int actualResult = someBusiness.calculateSum(new int[]{});
        int expectedResult = 0;
        Assert.assertEquals(expectedResult, actualResult);
    }
}