package by.grsu.smart.project.service.user;

import by.grsu.smart.project.entity.User;

public interface UserService {

    void saveUser(User user);

    User getUser(User user);

    User updateUser(User user);
}
