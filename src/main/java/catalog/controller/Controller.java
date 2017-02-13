package catalog.controller;


import catalog.controller.command.Command;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public final class Controller {
    private static final Logger LOG = LogManager.getLogger(Controller.class);
    private final CommandProvider provider = new CommandProvider();

    public String executeCommand(String request)  {
        LOG.info("start executeCommand(String request)");

        String command = request.substring(0, request.indexOf("/"));
        Command executeCommand = provider.getCommand(command);
        String response = executeCommand.execute(request);
        LOG.info("finish executeCommand(String request)");

        return response;
    }
}
