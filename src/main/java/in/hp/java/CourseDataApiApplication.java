package in.hp.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class CourseDataApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseDataApiApplication.class, args);
	}

	/**
	 * In this bean we are configuring default locale and returning
	 * If a locale is not being sent in request this default will be used
	 * @return
	 */
	@Bean
	public LocaleResolver buildLocale() {
		SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
		sessionLocaleResolver.setDefaultLocale(Locale.US);
		return sessionLocaleResolver;
	}

	/**
	 * ResourceBundle is collection of resources files in resource folder
	 * ResourceBundleMessageSource is collection of message source
	 * Here we are using it to bundle i18n messages
	 *
	 * @return
	 */
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
		/**
		 * Basename is the common name of the files inside the bundle
		 */
		resourceBundleMessageSource.setBasename("messages");
		return resourceBundleMessageSource;
	}
}
