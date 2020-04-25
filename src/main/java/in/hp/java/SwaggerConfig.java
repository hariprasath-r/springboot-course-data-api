package in.hp.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.*;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final Contact DEFAULT_CONTACT = new Contact(
            "Hariprasath",
            "https://www.github.com/hariprasath-r",
            "");

    private static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
            "Course Data API",
            "Provides Creation and Maintaining Courses",
            "1.0",
            "urn:tos",
            DEFAULT_CONTACT,
            "Apache 2.0",
            "http://www.apache.org/licenses/LICENSE-2.0",
            new ArrayList<VendorExtension>());

    private static final Set<String> DEFAULT_PRODUCES_CONSUMES =
            new HashSet<>(Arrays.asList("application/json", "application.xml"));

    @Bean
    public Docket configureDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO)
                .produces(DEFAULT_PRODUCES_CONSUMES)
                .consumes(DEFAULT_PRODUCES_CONSUMES);
    }
}
