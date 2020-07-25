package in.hp.java.boot.testing;

import java.util.Arrays;

public class SomeBusinessImpl {

    private SomeDataService someDataService;

    public int calculateSum(int[] data) {
        return Arrays.stream(data).reduce(0, Integer::sum);
    }
}
