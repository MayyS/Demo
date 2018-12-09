package edu.service.impl;

import edu.dao.MovieDao;
import edu.dao.impl.MovieDaoImpl;
import edu.entity.Movie;
import edu.entity.PageResult;
import edu.service.MovieService;
import org.hibernate.criterion.Criterion;

import java.util.List;

public class MovieServiceImpl implements MovieService {

    MovieDao movieDao=new MovieDaoImpl();
    @Override
    public List<Movie> findObject(String hql) {
        return movieDao.findObject(hql);
    }

    @Override
    public int save(Movie entity) {
        return movieDao.save(entity);
    }

    @Override
    public void update(Movie entity) {
        movieDao.update(entity);
    }

    @Override
    public void delete(Movie entity) {
        movieDao.delete(entity);
    }

    @Override
    public PageResult findObject(String hql, Integer pageNo, Integer pageSize) {
         List<Movie>movielist=movieDao.findObject(hql,pageNo,pageSize);
         Long totalCount=movieDao.findTotalCount(hql);
         PageResult pageResult=new PageResult(totalCount,pageNo,pageSize,movielist);
         return pageResult;
    }

    @Override
    public PageResult searchObject(String attr, String val,Integer pageNo,Integer pageSize) {
        List<Movie>movieList=movieDao.searchObject(attr,val,pageNo,pageSize);
        Long totalCount=movieDao.findTotalCount(attr,val);
        PageResult pageResult=new PageResult(totalCount,pageNo,pageSize,movieList);
        return pageResult;

    }

    @Override
    public Movie findById(Integer id) {
        return movieDao.findById(id);
    }


    @Override
    public PageResult findObject(Criterion criterion, Integer pageNo, Integer pageSize) {
        List<Movie>movieList=movieDao.findObject(criterion,pageNo,pageSize);
        Long totalCount=movieDao.findTotalCount(criterion);
        PageResult pageResult=new PageResult(totalCount,pageNo,pageSize,movieList);
        return pageResult;
    }
}
