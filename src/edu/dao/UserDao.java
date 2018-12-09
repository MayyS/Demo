package edu.dao;

import edu.base.dao.BaseDao;
import edu.entity.User;

public interface UserDao extends BaseDao<User> {
    public User checkIn(User user);
    public boolean existed(User user);
    public int save(User user);
}
