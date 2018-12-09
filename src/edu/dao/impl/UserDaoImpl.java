package edu.dao.impl;

import edu.base.dao.impl.BaseDaoimpl;
import edu.dao.UserDao;
import edu.entity.User;
import edu.util.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoImpl extends BaseDaoimpl<User> implements UserDao {

    @Override
    public User checkIn(User user) {
        Session session= HibernateUtils.getSession();
        Query query=session.createQuery("from User where account = ? and password = ?");
        query.setParameter(0,user.getAccount());
        query.setParameter(1,user.getPassword());
        List<User>list=query.list();
        session.close();
        if (list.size()>0)
            return list.get(0);
        return null;
    }

    @Override
    public boolean existed(User user) {
        Session session= HibernateUtils.getSession();
        Query query=session.createQuery("from User where account = ?");
        query.setParameter(0,user.getAccount());
        List<User>list=query.list();
        if (list.size()>0)
            return true;
        return false;
    }

    public int save(User user){
        return super.save(user);
    }



}
