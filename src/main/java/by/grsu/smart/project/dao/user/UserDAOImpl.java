package by.grsu.smart.project.dao.user;

import by.grsu.smart.project.dao.BaseDAO;
import by.grsu.smart.project.entity.User;
import org.hibernate.Query;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDAOImpl extends BaseDAO implements UserDAO {
    private final static Logger logger = Logger.getLogger(UserDAOImpl.class);

    @Override
    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
        logger.info("Saved user - " + user);
    }

    @Override
    public User update(User user) {
        User oldUser = getUser(user);
        oldUser.setFirstName(user.getFirstName());
        oldUser.setSurname(user.getSurname());
        oldUser.setPhoneNumber(user.getPhoneNumber());

        sessionFactory.getCurrentSession().update(oldUser);

        logger.info("Updated user - " + user);

        return null;
    }

    @Override
    public User getUser(User user) {
        String queryString = "select u from User u " +
                "where u.email = :email and u.password = :password";

        Query query = sessionFactory.getCurrentSession().createQuery(queryString);
        query.setParameter("email", user.getEmail());
        query.setParameter("password", user.getPassword());

        return (User) query.uniqueResult();
//        return sessionFactory.getCurrentSession().get(User.class, user.getId())
    }
}
