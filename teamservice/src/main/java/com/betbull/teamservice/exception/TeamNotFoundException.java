package com.betbull.teamservice.exception;

public class TeamNotFoundException extends ApplicationException {
    public TeamNotFoundException(Long id) {
        super("TeamNotFoundException", String.format("Team with id:%s not found!", id));
    }

}
