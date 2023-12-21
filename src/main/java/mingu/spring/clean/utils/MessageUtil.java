package mingu.spring.clean.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MessageUtil {

    private static MessageSource messageSource;

    @Autowired
    public MessageUtil(MessageSource messageSource) {
        MessageUtil.messageSource = messageSource;
    }

    public static String getMessage(MessageCode messageCode, Object... args) {
        try {
            return messageSource.getMessage(messageCode.name(), args, LocaleContextHolder.getLocale());
        } catch (Exception e) {
            return String.format("Undefined message code : %s", messageCode.name());
        }
    }
}
