package in.hp.java.boot.testing;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJTest {

    @Test
    public void assertJTestList() {
        List<Integer> integers = Arrays.asList(12, 14, 16, 18);

        assertThat(integers)
                .hasSize(4)
                .allMatch(x -> x > 10)
                .noneMatch(x -> x < 0);
    }

    @Test
    public void assertJString() {
        String s = "ABCDEF";

        assertThat(s).contains("BC")
                .startsWith("AB")
                .doesNotContainAnyWhitespaces();

    }
}
