package edu.service.impl;

import edu.dao.UserDao;
import edu.dao.impl.UserDaoImpl;
import edu.entity.PageResult;
import edu.entity.User;
import edu.service.UserService;
import edu.util.Md5Utils;
import org.hibernate.criterion.Criterion;

import java.util.List;
/*

public class UserSeriveImpl extends BaseSerivceImpl<User> implements UserService {
    private UserDao userDao=new UserDaoImpl();
    @Override
    public User checkIn(User user) {
        return userDao.checkIn(user);
    }
}
*/
public class UserSeriveImpl implements UserService {

    private UserDao userDao=new UserDaoImpl();
    @Override
    public User checkIn(User user) {
        return userDao.checkIn(user);
    }

    @Override
    public User findUser(Criterion criterion) {
        return userDao.findObject(criterion);
    }


    @Override
    public List<User> findObject(String hql) {
        return userDao.findObject(hql);
    }

    @Override
    public int save(User entity) {
        String pwd= Md5Utils.md5(entity.getPassword());
        entity.setPassword(pwd);
        if (userDao.existed(entity))
            return -1;
        return userDao.save(entity);
    }

    @Override
    public void update(User entity) {
        userDao.update(entity);
    }

    @Override
    public void delete(User entity) {
        userDao.delete(entity);
    }

    @Override
    public PageResult findObject(String hql, Integer pageNo, Integer pageSize) {
        Long totalCount=userDao.findTotalCount();
        List<User>items=userDao.findObject(hql,pageNo,pageSize);
        return new PageResult(totalCount,pageNo,pageSize,items);
    }

    @Override
    public PageResult searchObject(String attr, String val, Integer pageNo, Integer pageSize) {
        return null;
    }

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }
}