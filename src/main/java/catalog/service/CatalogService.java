package catalog.service;


import catalog.bean.NewsItem;
import catalog.service.exception.ServiceException;

import java.util.ArrayList;

public interface CatalogService {

    NewsItem addNewsItem(String category, String title, String additionalInfo, String year) throws ServiceException;
    ArrayList<NewsItem> searchNewsItemByTitle(String title)throws ServiceException;
    ArrayList<NewsItem> searchNewsItemByYear(String date)throws ServiceException;

}
