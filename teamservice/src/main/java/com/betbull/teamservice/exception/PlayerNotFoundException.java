package com.betbull.teamservice.exception;

public class PlayerNotFoundException extends ApplicationException {
    public PlayerNotFoundException(Long id) {
        super("PlayerNotFoundException", String.format("Player with id:%s not found!", id));
    }

}
