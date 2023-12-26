package mingu.spring.clean.entity.rentalCompany.exception;

import mingu.spring.clean.utils.MessageCode;
import mingu.spring.clean.utils.MessageUtil;

public class RentalCompanyNotFoundException extends Exception {
    public RentalCompanyNotFoundException() {
        super(MessageUtil.getMessage(MessageCode.RENTAL_COMPANY_EXCEPTION_NOT_FOUND));
    }
}
