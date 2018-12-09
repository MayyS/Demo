package edu.base.dao.impl;

import edu.base.dao.BaseDao;
import edu.util.HibernateUtils;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class BaseDaoimpl<T> implements BaseDao<T> {
    private Class<T> clazz;
    public BaseDaoimpl() {
        Type type=this.getClass().getGenericSuperclass();
        ParameterizedType pt=(ParameterizedType)type;
        Type[] types=pt.getActualTypeArguments();
        clazz=(Class<T>)types[0];
        System.out.println(clazz.getSimpleName()+""+clazz+""+clazz);
    }

    @Override
    public List<T> findObject(String hql) {
        Session session= HibernateUtils.getSession();
        Query query=session.createQuery(hql);
        session.close();
        return query.list();
    }

    @Override
    public int save(T entity) {
        Session session=HibernateUtils.getSession();
        Transaction tx=session.beginTransaction();
        int i=0;
        try {
            session.save(entity);
            tx.commit();
            i=1;
        } catch (Exception e) {
            tx.rollback();
            i=-1;
            e.printStackTrace();
        }finally {
            session.close();
        }
        return i;
    }


    @Override
    public void update(T entity) {
        Session session=HibernateUtils.getSession();
        try {
            Transaction tx=session.beginTransaction();
            session.update(entity);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Override
    public void delete(T entity) {
        Session session=HibernateUtils.getSession();
        try {
            Transaction tx=session.beginTransaction();
            session.delete(entity);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Override
    public List<T> findObject(String hql, Integer pageNo, Integer pageSize) {
        Session session=HibernateUtils.getSession();
        Query query=session.createQuery(hql);
        query.setFirstResult((pageNo-1)*pageSize);
        query.setMaxResults(pageSize);
        List list=query.list();
        session.close();
        return list;
    }

    @Override
    public List<T> searchObject(String attr, String val,Integer pageNo,Integer pageSize) {
        Session session=HibernateUtils.getSession();
        Criteria criteria =session.createCriteria(clazz).add(Restrictions.like(attr,"%"+val+"%"));
        criteria.setFirstResult((pageNo-1)*pageSize);
        criteria.setMaxResults(pageSize);
        List list=criteria.list();
        session.close();

        return list;
    }

    @Override
    public Long findTotalCount() {
        Session session=HibernateUtils.getSession();
        Query query=session.createQuery("select count(1) from "+clazz.getSimpleName());
        Long count=(Long)query.uniqueResult();
        session.close();
        return count;
    }
    public Long findTotalCount(String attr, String val) {
        Session session=HibernateUtils.getSession();
        Long count=new Long(session.createCriteria(clazz).add(Restrictions.like(attr,"%"+val+"%")).list().size());
        System.out.println(count);
        session.close();
        return count;
    }

    @Override
    public Long findTotalCount(Criterion criterion) {
        Session session=HibernateUtils.getSession();
        Long count=new Long(session.createCriteria(clazz).add(criterion).list().size());
        System.out.println(count);
        session.close();
        return count;
    }

    @Override
    public T findById(Integer id) {
        Session session=HibernateUtils.getSession();
        T obj= (T)session.get(clazz,id);
        session.close();
        return obj;
    }

    @Override
    public List<T> findObject(Criterion criterion, Integer pageNo, Integer pageSize) {
        Session session=HibernateUtils.getSession();
        Criteria criteria=session.createCriteria(clazz);
        criteria.add(criterion);
        criteria.setFirstResult((pageNo-1)*pageSize);
        criteria.setMaxResults(pageSize);
        List list=criteria.list();
        session.close();
        return list;
    }

    @Override
    public T findObject(Criterion criterion) {
        Session session=HibernateUtils.getSession();
        Criteria criteria=session.createCriteria(clazz);
        criteria.add(criterion);
        List list=criteria.list();
        session.close();
        return (T) list.get(0);
    }
}
