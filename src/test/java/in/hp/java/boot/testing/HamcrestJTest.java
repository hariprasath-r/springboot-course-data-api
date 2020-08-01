package in.hp.java.boot.testing;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

public class HamcrestJTest {

    @Test
    public void hamcrestTest() {
        List<Integer> integers = Arrays.asList(12, 14, 16, 18);

        assertThat(integers, hasSize(4));
        assertThat(integers, Matchers.hasItems(12,16));
    }
}
