package edu.dao;

import edu.base.dao.BaseDao;
import edu.entity.Movie;

public interface MovieDao extends BaseDao<Movie> {
    public Long findTotalCount(String hql);

}
