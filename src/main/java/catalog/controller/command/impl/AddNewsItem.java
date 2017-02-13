package catalog.controller.command.impl;

import catalog.controller.command.Command;
import catalog.service.CatalogService;
import catalog.service.factory.ServiceFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import catalog.service.exception.ServiceException;

public class AddNewsItem implements Command {
    private static final Logger LOG = LogManager.getLogger(AddNewsItem.class);

    public String execute(String newItem) {
        LOG.info("start execute(String newItem)");
        String response = "";
        String[] array = newItem.split("/");

        if (array.length == 5) {
            String category = array[1];
            String title = array[2];
            String additionalinfo = array[3];
            String year = array[4];
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            CatalogService catalogService = serviceFactory.getCatalogService();

            try {
                catalogService.addNewsItem(category, title, additionalinfo, year);
                LOG.info("news added");
                response = "NewsItem added\n";

            } catch (IndexOutOfBoundsException | ServiceException e) {
                LOG.error("News was not add");
                response = "News adding error";
            }
        }else {
            LOG.error("wrong format");
            response ="You can add all info about news.";
        }
        LOG.info("finish execute(String newItem)");
        return response;

    }
}
