package com.betbull.teamservice.exception;

import static java.text.MessageFormat.format;

public class ApplicationException extends RuntimeException {
    private static final long serialVersionUID = -4445077739033521957L;

    final String code;
    final String description;

    public ApplicationException(String code, String description) {
        super(message(code, description));
        this.code = code;
        this.description = description;
    }

    public ApplicationException(String code, String description, Throwable ex) {
        super(message(code, description), ex);
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    static String message(String code, String description) {
        return format("Code: {0}, Description: {1}", code, description);
    }
}