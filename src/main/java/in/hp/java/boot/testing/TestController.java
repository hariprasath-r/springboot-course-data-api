package in.hp.java.boot.testing;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/hello-mockito")
    public String helloMockito() {
        return "Hello Mockito";
    }
}
