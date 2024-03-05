package hiber.dao;

import hiber.model.User;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();
   User getUserByCar(String model, Integer series);
}
