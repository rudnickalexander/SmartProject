package by.grsu.smart.project.dao.user;

import by.grsu.smart.project.dao.BaseDAO;
import by.grsu.smart.project.entity.User;
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
    public void update(User user) {
//        User oldUser = sessionFactory.getCurrentSession().load(User.class, user.getId());

        logger.info("Updated user - " + user);
    }
}
