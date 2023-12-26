package mingu.spring.clean.entity.user.exception;

import mingu.spring.clean.utils.MessageCode;
import mingu.spring.clean.utils.MessageUtil;

public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super(MessageUtil.getMessage(MessageCode.USER_EXCEPTION_NOT_FOUND));
    }
}
