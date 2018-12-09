/*
package edu.base.service.impl;

import edu.base.dao.BaseDao;
import edu.base.dao.impl.BaseDaoimpl;
import edu.base.service.BaseService;
import edu.entity.PageResult;

import java.util.List;

public class BaseSerivceImpl<T> implements BaseService<T> {
    private BaseDao<T> baseDao=new BaseDaoimpl<T>();
    @Override
    public List<T> findObject(String hql) {
       return baseDao.findObject(hql);
    }

    @Override
    public int save(T entity) {
        return baseDao.save(entity);
    }

    @Override
    public void update(T entity) {
        baseDao.update(entity);
    }

    @Override
    public void delete(T entity) {
        baseDao.delete(entity);
    }

    @Override
    public PageResult findObject(String hql, Integer pageNo, Integer pageSize) {
        List<T> items=baseDao.findObject(hql,pageNo,pageSize);
        Long totalCount=baseDao.findTotalCount();
        return new PageResult(totalCount,pageNo,pageSize,items);


    }

    @Override
    public List<T> searchObject(String attr, String val) {
        List<T> items=baseDao.searchObject(attr,val);
        Long totalCount=baseDao.findTotalCount(attr,val);
        return items;
    }
}
*/
