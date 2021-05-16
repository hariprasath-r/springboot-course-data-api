package in.hp.java.boot.testing;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    private String actualResponse = "{\"id\": \"1\", \"name\": \"Java\", \"description\": \"Java Topic\"}";

    @Test
    public void jsonAssertTest_strictTrue() throws JSONException {
        String expectedResponse = "{\"id\": \"1\", \"name\": \"Java\", \"description\": \"Java Topic\"}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, true);
    }

    /**
     * The Space is little bit tricky, so be sure to not have any difference
     * @throws JSONException
     */
    @Test
    public void jsonAssertTest_strictTrueWithSpaces() throws JSONException {
        String expectedResponse = "{\"id\":\"1\", \"name\": Java , \"description\": \"Java Topic\"}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, true);
    }

    @Test
    public void jsonAssertTest_strictTrueAndFalseDiff() throws JSONException {
        String expectedResponse = "{\"id\":\"1\", \"name\": Java , \"description\": \"Java Topic\"}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, true);

        expectedResponse = "{\"name\": Java , \"description\": \"Java Topic\"}";
        JSONAssert.assertNotEquals(expectedResponse, actualResponse, true);

        // strict false, relaxes to check all values are there are not
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }
}
