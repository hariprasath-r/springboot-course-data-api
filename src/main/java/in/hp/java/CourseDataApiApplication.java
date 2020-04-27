package in.hp.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class CourseDataApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseDataApiApplication.class, args);
	}

	/**
	 * In this bean we are configuring default locale and returning
	 * If a locale is not being sent in request this default will be used
	 *
	 * Since we are fetching from header here
	 * 		replacing SessionLocaleResolver to AcceptHeaderLocaleResolver
	 *
	 * @return AcceptHeaderLocaleResolver
	 */
	@Bean
	public LocaleResolver buildLocale() {
		AcceptHeaderLocaleResolver acceptHeaderLocaleResolver = new AcceptHeaderLocaleResolver();
		acceptHeaderLocaleResolver.setDefaultLocale(Locale.US);
		return acceptHeaderLocaleResolver;
	}

}
