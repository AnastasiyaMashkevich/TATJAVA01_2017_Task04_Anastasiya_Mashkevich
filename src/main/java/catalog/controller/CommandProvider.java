package catalog.controller;

import catalog.controller.command.Command;
import catalog.controller.command.CommandName;
import catalog.controller.command.impl.AddNewsItem;
import catalog.controller.command.impl.SearchNewsItemByTitle;
import catalog.controller.command.impl.SearchNewsItemByYear;
import catalog.controller.command.impl.WrongRequest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;



public final class CommandProvider {
    private static final Logger LOG = LogManager.getLogger(CommandProvider.class);

    private final Map<CommandName, Command> commandList = new HashMap<CommandName,Command>();

    CommandProvider() {
        commandList.put(CommandName.ADD_NEWS_ITEM, new AddNewsItem());
        commandList.put(CommandName.SEARCH_BY_TITLE, new SearchNewsItemByTitle());
        commandList.put(CommandName.SEARCH_BY_YEAR, new SearchNewsItemByYear());
        commandList.put(CommandName.WRONG_REQUEST, new WrongRequest());
    }

    Command getCommand(String request) {
        LOG.info("start getCommand(String request)");

        CommandName commandName;
        Command command;
        try{
            commandName = CommandName.valueOf(request.toUpperCase());
            command = commandList.get(commandName);

        }catch(IllegalArgumentException | NullPointerException e){

            command = commandList.get(CommandName.WRONG_REQUEST);
        }
        LOG.info("finish getCommand(CommandName request)");

        return command;
    }
}


