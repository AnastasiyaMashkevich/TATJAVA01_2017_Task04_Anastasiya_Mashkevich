package catalog.dao.factory;


import catalog.dao.NewsDao;
import catalog.dao.impl.NewsDaoImpl;

public class DAOFactory {

    private final static DAOFactory factory = new DAOFactory();

    private DAOFactory(){

    }

    public static DAOFactory getInstance(){
        return factory;
    }

    public NewsDao getNewsDAO(){
        return new NewsDaoImpl();
    }

}



