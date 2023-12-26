package mingu.spring.clean.entity.rental.exception;

import mingu.spring.clean.utils.MessageCode;
import mingu.spring.clean.utils.MessageUtil;

public class RentalNotFoundException extends Exception {
    public RentalNotFoundException() {
        super(MessageUtil.getMessage(MessageCode.RENTAL_EXCEPTION_NOT_FOUND));
    }
}
