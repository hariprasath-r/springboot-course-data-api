package in.hp.java.boot.topic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/test")
public class UTTopicController {

    @GetMapping("/get-topic")
    public Topic getTopic() {
        return new Topic("1", "Java", "Java Topic");
    }
}
