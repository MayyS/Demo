package edu.service;

import edu.base.service.BaseService;
import edu.entity.User;
import org.hibernate.criterion.Criterion;

public interface UserService extends BaseService<User> {
    public User checkIn(User user);
    public User findUser(Criterion criterion);
}
