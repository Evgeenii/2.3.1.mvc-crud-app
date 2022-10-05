package web.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import web.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void saveUser(User user) {
        sessionFactory.getCurrentSession()
                .save(user);
    }

    @Override
    public void removeUserById(long id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.load(User.class, id);
        session.delete(user);
    }

    @Override
    public List<User> getAllUsers() {
        return sessionFactory.getCurrentSession()
                .createQuery("from User", User.class)
                .list();
    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public User getUserById(long id) {
        return sessionFactory.getCurrentSession()
                .get(User.class, id);
    }

    @Override
    public void truncateTable() {
        sessionFactory.getCurrentSession()
                .createNativeQuery("TRUNCATE TABLE users;")
                .executeUpdate();
    }
}
