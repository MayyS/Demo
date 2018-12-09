package edu.util;

import edu.dao.MovieDao;
import edu.dao.impl.MovieDaoImpl;

public class DaoFactory {
    public static MovieDao getMovidDaoInstance(){
        return new MovieDaoImpl();
    }
}
