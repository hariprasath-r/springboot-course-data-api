package in.hp.java.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class InternationalizationDemo {

    /**
     * Autowiring message source to read the messages against passed input
     */
    @Autowired
    ResourceBundleMessageSource messageSource;

    @GetMapping("/greeting")
    public String greet() {
        return "Good Morning";
    }

    /**
     * Injecting the locale from request from the header
     * Accept-Language - where locale is passed
     * required - false, since we already have default locale configured
     *
     * Instead of accepting from header everywhere, we can use LocaleContextHolder to retrieve the value
     *
     * @return
     */
    @GetMapping("/i18n")
    public String internationalGreeting() {
        return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
    }
}
