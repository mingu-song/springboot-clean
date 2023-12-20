package mingu.spring.clean.infrastructure.config.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;

import java.util.ResourceBundle;

@Configuration
public class ResolverConfig {

    @Bean
    public ResourceBundle resourceBundle() {
        // ValidationMessages is default value
        return ResourceBundle.getBundle("ValidationMessages");
    }

    @Bean
    public LocaleResolver acceptHeaderResolver() {
        return new AcceptHeaderResolver();
    }
}
