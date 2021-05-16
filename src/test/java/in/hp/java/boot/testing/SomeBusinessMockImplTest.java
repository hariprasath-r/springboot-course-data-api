package in.hp.java.boot.testing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockImplTest {

    @InjectMocks
    private SomeBusinessImpl someBusiness;

    @Mock
    private SomeDataService someDataService;

    @Test
    public void calculateSumUsingDataService() {
        when(someDataService.retrieveData()).thenReturn(new int[]{1, 2, 3});

        int actualResult = someBusiness.calculateSumUsingDataService();
        int expectedResult = 6;
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataService_withOneValue() {
        when(someDataService.retrieveData()).thenReturn(new int[]{1});

        int actualResult = someBusiness.calculateSumUsingDataService();
        int expectedResult = 1;
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataService_withNoValue() {
        when(someDataService.retrieveData()).thenReturn(new int[]{});

        int actualResult = someBusiness.calculateSumUsingDataService();
        int expectedResult = 0;
        Assert.assertEquals(expectedResult, actualResult);
    }

}