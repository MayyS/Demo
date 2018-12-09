package edu.base.dao;

import org.hibernate.criterion.Criterion;

import java.util.List;

public interface BaseDao<T> {
    public List<T> findObject(String hql);
    public int save(T entity);
    public void update(T entity);
    public void delete(T entity);

    public List<T>findObject(String hql,Integer pageNo,Integer pageSize);

    public List<T>searchObject(String attr,String val,Integer pageNo,Integer pageSize);

    public Long findTotalCount();
    public Long findTotalCount(String attr,String val);
    public Long findTotalCount(Criterion criterion);

    public T findById(Integer id);

    public List<T>findObject(Criterion criterion, Integer pageNo, Integer pageSize);

    public T findObject(Criterion criterion);
}
