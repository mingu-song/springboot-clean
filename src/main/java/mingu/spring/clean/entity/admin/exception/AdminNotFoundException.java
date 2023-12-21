package mingu.spring.clean.entity.admin.exception;

import mingu.spring.clean.utils.MessageCode;
import mingu.spring.clean.utils.MessageUtil;

public class AdminNotFoundException extends Exception {

    public AdminNotFoundException() {
        super(MessageUtil.getMessage(MessageCode.ADMIN_EXCEPTION_NOT_FOUND));
    }
}
