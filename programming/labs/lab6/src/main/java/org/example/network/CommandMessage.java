package org.example.network;

import java.io.Serializable;

public class CommandMessage implements Serializable {
    private final Command command;
    private final Object[] args;

    public CommandMessage(Command command, Object... args) {
        this.command = command;
        this.args = args;
    }

    public Command getCommand() {
        return command;
    }

    public Object[] getArgs() {
        return args;
    }
}