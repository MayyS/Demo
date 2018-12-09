package edu.service;

import edu.base.service.BaseService;
import edu.entity.Movie;
import edu.entity.PageResult;
import org.hibernate.criterion.Criterion;

public interface MovieService extends BaseService<Movie> {
    public PageResult findObject(Criterion criterion, Integer pageNo, Integer pageSize);

}
