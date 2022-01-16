package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
   @Autowired
   private SessionFactory sessionFactory;

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Transactional
   @Override
   public User findOwner(String model, int series) {
      Query findCarQuery = sessionFactory.getCurrentSession().createQuery(
                      "select user from User user where user.car.model =  :model and user.car.series = :series")
              .setParameter("model", model)
              .setParameter("series", series);
      return (User) findCarQuery.getSingleResult();
   }

}
