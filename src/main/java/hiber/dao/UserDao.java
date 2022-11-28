package hiber.dao;

import hiber.model.User;

import javax.persistence.NoResultException;
import java.util.List;

public interface UserDao {
    void add(User user);
    List<User> getUsers();

    User getUserByCar(String model, int series);
}
