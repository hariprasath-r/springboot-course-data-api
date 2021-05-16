package in.hp.java.boot.testing;

import java.util.Arrays;

public class SomeBusinessImpl {

    private SomeDataService someDataService;

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public int calculateSum(int[] data) {
        return Arrays.stream(data).reduce(0, Integer::sum);
    }

    public int calculateSumUsingDataService() {
        int[] data = someDataService.retrieveData();
        return calculateSum(data);
    }
}
