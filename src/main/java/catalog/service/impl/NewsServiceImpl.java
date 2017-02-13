package catalog.service.impl;

import catalog.bean.NewsItem;
import catalog.dao.NewsDao;
import catalog.dao.exception.DAOException;
import catalog.dao.factory.DAOFactory;
import catalog.service.CatalogService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import catalog.service.exception.ServiceException;

import java.util.ArrayList;

public class NewsServiceImpl implements CatalogService {
    private static final Logger LOG = LogManager.getLogger(NewsServiceImpl.class);

    public NewsItem addNewsItem(String category, String title, String additionalInfo, String year) throws ServiceException {
        if (checkCategory(category)) {
            try {
                LOG.info("start addNewsItem(String category, String title, String additionalInfo, String year)");
                DAOFactory daoObjectFactory = DAOFactory.getInstance();
                NewsDao newsDao = daoObjectFactory.getNewsDAO();
                NewsItem newsItem = new NewsItem(category, title, additionalInfo, year);
                if (category != null | title != null | additionalInfo != null | year != null) {
                    newsDao.addNewsItem(newsItem);
                    LOG.info("finish addNewsItem(String category, String title, String additionalInfo, String year)");
                    return newsItem;
                }
            } catch (DAOException e) {
                LOG.error("News was not added");
                throw new ServiceException(e);
            }
        } else {
            LOG.error("Wrong category");
            throw new ServiceException ("Wrong category");
        }
        LOG.info("Error addNewsItem(String category, String title, String additionalInfo, String year)");
        return null;
    }

        public ArrayList<NewsItem> searchNewsItemByTitle (String title) throws ServiceException {
            try {
                LOG.info("start searchNewsItemByTitle (String title)");
                DAOFactory daoObjectFactory = DAOFactory.getInstance();
                NewsDao newsItemDAO = daoObjectFactory.getNewsDAO();
                LOG.info(" finish searchNewsItemByTitle (String title)");
                return newsItemDAO.searchNewsItemsByTitle(title);
            } catch (DAOException e) {
                LOG.error("Not found news");
                throw new ServiceException(e);
            }
        }

        public ArrayList<NewsItem> searchNewsItemByYear (String year) throws ServiceException {
            try {
                LOG.info("start searchNewsItemByYear (String year)");
                DAOFactory daoObjectFactory = DAOFactory.getInstance();
                NewsDao newsItemDAO = daoObjectFactory.getNewsDAO();
                LOG.info("finish searchNewsItemByYear (String year)");
                return newsItemDAO.searchNewsItemByYear(year);
            } catch (DAOException e) {
                LOG.error("Not found news by year");
                throw new ServiceException(e);
            }
        }

        private boolean checkCategory (String category) {
            if (category.equals("movie") || category.equals("disk") || category.equals("book")) {
                return true;
            } else {
                return false;
            }
        }
    }
