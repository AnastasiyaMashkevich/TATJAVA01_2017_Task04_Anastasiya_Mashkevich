package catalog.controller.command.impl;

import catalog.bean.NewsItem;
import catalog.controller.command.Command;
import catalog.service.CatalogService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import catalog.service.factory.ServiceFactory;
import catalog.service.exception.ServiceException;

import java.util.ArrayList;

public class SearchNewsItemByYear implements Command {
    private static final Logger LOG = LogManager.getLogger(SearchNewsItemByYear.class);

    public String execute(String request) {
        LOG.info("start execute(String request)");

        String response;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CatalogService catalogService = serviceFactory.getCatalogService();
        String  [] array = request.split("/");
        ArrayList<NewsItem> result;
        try {
            result = catalogService.searchNewsItemByYear(array[1]);
        } catch (ServiceException e) {
            LOG.error("wrong request");
            return  "Search by year error";
        }
        if (result != null && result.size() > 0) {
            response = "Result: \n";
            for (NewsItem item : result) {
                response += item.toString() + "\n";
            }
            LOG.info("successful finish execute(String request)");
            return response.trim();
        }
        LOG.info("finish execute(String request)");
        return "Not Found";
    }
}
