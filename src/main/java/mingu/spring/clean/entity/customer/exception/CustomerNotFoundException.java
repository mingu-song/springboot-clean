package mingu.spring.clean.entity.customer.exception;

import mingu.spring.clean.utils.MessageCode;
import mingu.spring.clean.utils.MessageUtil;

public class CustomerNotFoundException extends Exception {
    public CustomerNotFoundException() {
        super(MessageUtil.getMessage(MessageCode.CUSTOMER_EXCEPTION_NOT_FOUND));
    }
}
