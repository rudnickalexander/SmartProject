package by.grsu.smart.project.dao.user;

import by.grsu.smart.project.entity.User;

public interface UserDAO {

    void save(User user);

    User update(User user);

    User getUser(User user);
}
