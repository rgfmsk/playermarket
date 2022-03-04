package com.betbull.teamservice.exception;

public class TransferNotFoundException extends ApplicationException {
    public TransferNotFoundException(Long id) {
        super("TransferNotFoundException", String.format("Transfer with id:%s not found!", id));
    }

}
