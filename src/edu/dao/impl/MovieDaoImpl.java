package edu.dao.impl;

import edu.base.dao.impl.BaseDaoimpl;
import edu.dao.MovieDao;
import edu.entity.Movie;
import edu.util.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;

public class MovieDaoImpl extends BaseDaoimpl<Movie> implements MovieDao {
    public Long findTotalCount(String hql) {
        Session session= HibernateUtils.getSession();
        Query query=session.createQuery("select count(1)"+hql);
        Long count=(Long)query.uniqueResult();
        session.close();
        return count;
    }
}
