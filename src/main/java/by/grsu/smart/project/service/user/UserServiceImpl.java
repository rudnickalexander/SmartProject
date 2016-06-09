package by.grsu.smart.project.service.user;

import by.grsu.smart.project.dao.user.UserDAO;
import by.grsu.smart.project.entity.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final static Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDAO userDAO;

    @Override
    public void saveUser(User user) {
        userDAO.save(user);
        logger.info("Saved user - " + user);
    }
}
