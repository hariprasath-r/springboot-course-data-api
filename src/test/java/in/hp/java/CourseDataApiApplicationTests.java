package in.hp.java;

import in.hp.java.boot.topic.Topic;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CourseDataApiApplicationTests {

	@Autowired
	TestRestTemplate restTemplate;

	@Test
	public void contextLoads() {
		ResponseEntity<Topic[]> response = restTemplate.getForEntity("/topics", Topic[].class);

		assertEquals(200, response.getStatusCodeValue());
		assertEquals(0, response.getBody().length);
	}

}
