package mingu.spring.clean.infrastructure.config.web;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class AcceptHeaderResolver extends AcceptHeaderLocaleResolver {

    private final List<Locale> LOCALES = Arrays.asList(new Locale("en"), new Locale("ko"));

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String headerLang = request.getHeader("Accept-Language");
        return StringUtils.hasText(headerLang) ? Locale.lookup(Locale.LanguageRange.parse(headerLang), LOCALES) : Locale.getDefault();
    }
}
