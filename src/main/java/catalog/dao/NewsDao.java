package catalog.dao;


import catalog.bean.NewsItem;
import catalog.dao.exception.DAOException;

import java.util.ArrayList;

public interface NewsDao {
    boolean addNewsItem(NewsItem newItem) throws DAOException;
    ArrayList<NewsItem> searchNewsItemsByTitle(String title)throws DAOException;
    ArrayList<NewsItem> searchNewsItemByYear(String year)throws DAOException;


}
