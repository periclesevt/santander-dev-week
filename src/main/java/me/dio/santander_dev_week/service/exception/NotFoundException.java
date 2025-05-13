package me.dio.santander_dev_week.service.exception;

import java.io.Serial;

public class NotFoundException extends BusinessException {

    @Serial
    private static final long serialVersionUID = 1L;

    public NotFoundException() {
        super("Resource not found.");
    }

}