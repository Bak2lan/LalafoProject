package service.impl;

import dao.impl.UserDaoImpl;
import db.DataBase;
import models.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private DataBase dataBase;
    private UserDaoImpl userDao;

    public UserServiceImpl(DataBase dataBase, UserDaoImpl userDao) {
        this.dataBase = dataBase;
        this.userDao = userDao;
    }

    @Override
    public User addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public String updateUser(Long id, User user) {
        return userDao.updateUser(id,user);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public String deleteUser(Long id) {
        return userDao.deleteUser(id);
    }

    @Override
    public User getUserByEmail(String userEmail) {
        return userDao.getUserByEmail(userEmail);
    }
}
