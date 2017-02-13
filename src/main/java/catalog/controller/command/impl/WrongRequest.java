package catalog.controller.command.impl;


import catalog.controller.command.Command;

public class WrongRequest implements Command {
    public String execute(String request) {
        return "Wrong request";
    }
}
