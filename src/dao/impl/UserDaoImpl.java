package dao.impl;

import dao.UserDao;
import db.DataBase;
import exception.MyException;
import models.User;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    private DataBase dataBase;
    private Long userID=1L;

    public UserDaoImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public User addUser(User user) {
        try {
            for (User user1 : dataBase.getUsers()) {
                if (user1.getEmail().equals(user.getEmail())) {
                    throw new MyException("User email " + user.getEmail() + " is already exist");
                }
            }
            user.setId(userID++);
            dataBase.getUsers().add(user);
            System.out.println("User successfully saved");
            return user;
        } catch (MyException myException) {
            System.out.println(myException.getMessage());
        }
        return null;
    }

    @Override
    public User getUserById(Long id) {
        try {
            for (User user : dataBase.getUsers()) {
                if (user.getId().equals(id)) {
                    return user;
                }
            }
            throw new MyException("Not found User id");
        } catch (MyException myException) {
            System.out.println(myException.getMessage());
        }
        return null;
    }

    @Override
    public String updateUser(Long id, User user) {
        try {
            for (User us : dataBase.getUsers()) {
                if (us.getId().equals(id)) {
                    us.setFirstName(user.getFirstName());
                    us.setEmail(user.getEmail());
                    us.setRole(us.getRole());
                    us.setPassword(user.getPassword());
                    return "User with " + id + " id successfully updated";
                }
            }
            throw new MyException("Not found user with " + id + " id not found");
        } catch (MyException myException) {
            System.out.println(myException.getMessage());
        }
        return null;
    }

    @Override
    public List<User> getAllUser() {
        return dataBase.getUsers();
    }

    @Override
    public String deleteUser(Long id) {
        try {
            Iterator<User> iterator = dataBase.getUsers().iterator();
            while (iterator.hasNext()) {
                User user = iterator.next();
                if (user.getId().equals(id)) {
                    iterator.remove();
                    return "User successfully deleted";
                }
            }
            throw new MyException("Not found User with this id");

        } catch (MyException myException) {
            System.out.println(myException.getMessage());
        }
        return null;
    }

    @Override
    public User getUserByEmail(String userEmail) {
        try {
            Optional<User> first = dataBase.getUsers().stream()
                    .filter(user -> user.getEmail().equals(userEmail))
                    .findFirst();
            if (first.isEmpty()) {
                throw new MyException("Not found user email, please provide included id");
            } else return first.get();
        } catch (MyException myException) {
            System.out.println(myException.getMessage());
        }
        return null;
    }
}
