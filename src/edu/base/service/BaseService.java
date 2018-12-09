package edu.base.service;

import edu.base.dao.BaseDao;
import edu.entity.PageResult;

import java.util.List;

public interface BaseService <T>  {
    public List<T> findObject(String hql);
    public int save(T entity);
    public void update(T entity);
    public void delete(T entity);
    public PageResult findObject(String hql, Integer pageNo, Integer pageSize);
    public PageResult searchObject(String attr, String val,Integer pageNo,Integer pageSize);
    public T findById(Integer id);

}
