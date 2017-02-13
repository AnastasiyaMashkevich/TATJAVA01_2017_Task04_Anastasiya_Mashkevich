package catalog.dao.impl;
import catalog.bean.NewsItem;
import catalog.dao.impl.connectionpool.ConnectionPool;
import catalog.dao.impl.connectionpool.ConnectionPoolException;
import catalog.dao.NewsDao;
import catalog.dao.exception.DAOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class NewsDaoImpl implements NewsDao {
    private static final Logger LOG = LogManager.getLogger(NewsDaoImpl.class);
    public final String INS_INTO_CATALOG = "INSERT INTO `catalog` (category, title, additionalInfo, year) VALUES ";
    public final String SEL_BY_TILE = "SELECT * FROM `catalog` WHERE title like";
    public final String SEL_BY_YEAR = "SELECT * FROM `catalog` WHERE year like";

    public boolean addNewsItem(NewsItem newItem) throws DAOException {
        LOG.info("start addNewsItem(NewsItem newItem)");

        Connection conn = null;
        Statement statement = null;
        try {
            conn = NewsDaoImpl.getConnect();

            String queryUp = INS_INTO_CATALOG + "(\"" + newItem.getCategory() + "\", \"" + newItem.getTitle() + "\", \"" + newItem.getAdditionalInfo() + "\", + \"" + newItem.getYear() + "\")";
            statement = conn.createStatement();
            int upd = statement.executeUpdate(queryUp);
            if (upd!=0) {
                LOG.info("successful finish addNewsItem(NewsItem newItem)");
                return true;
            }
        } catch (SQLException | ConnectionPoolException e) {
            LOG.warn("Connection Problem");
            throw new DAOException("Connection Problem", e);
        } finally {
            ConnectionPool.getInstance().closeConnection(conn, statement);
        }
        LOG.info("Error addNewsItem(NewsItem newItem)");
        return false;
    }

    public ArrayList<NewsItem> searchNewsItemsByTitle(String title) throws DAOException {
        LOG.info("start searchNewsItemsByTitle(String title)");
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        String queryToTableCatalog;
        try {
            conn = NewsDaoImpl.getConnect();
            queryToTableCatalog = SEL_BY_TILE + "'%" + title + "%'";
            statement = conn.createStatement();
            rs = statement.executeQuery(queryToTableCatalog);
            ArrayList<NewsItem> list = new ArrayList<NewsItem>();
            if (rs.next()) {
                list.add(new NewsItem(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
                LOG.info("successful finish searchNewsItemsByTitle(String title)");
                return list;
            }
        }catch (SQLException | ConnectionPoolException e) {
            LOG.warn("Connection Problem");
            throw new DAOException("Connection Problem", e);
        } finally {
            ConnectionPool.getInstance().closeConnection(conn, statement, rs);
        }
        LOG.info("Error searchNewsItemsByTitle(String title)");
        return null;
    }
    public ArrayList<NewsItem> searchNewsItemByYear(String year)throws DAOException {
        LOG.info("start searchNewsItemByYear(String year)");
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        String queryToTableCatalog;
        try {
            conn = NewsDaoImpl.getConnect();
            queryToTableCatalog = SEL_BY_YEAR+ "'%" + year + "%'";
            statement = conn.createStatement();
            rs = statement.executeQuery(queryToTableCatalog);
            ArrayList<NewsItem> list = new ArrayList<NewsItem>();
            if (rs.next()) {
                list.add(new NewsItem(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
                LOG.info("successful finish searchNewsItemByYear(String year)");
                return list;
            }
        }catch (SQLException | ConnectionPoolException e) {
            LOG.warn("Connection Problem");
            throw new DAOException("Connection Problem", e);
        } finally {
            ConnectionPool.getInstance().closeConnection(conn, statement, rs);
        }
        LOG.info("Error searchNewsItemByYear(String year)");
        return null;
    }

    public static Connection getConnect() throws ConnectionPoolException {
        return ConnectionPool.getInstance().takeConnection();

    }
}
