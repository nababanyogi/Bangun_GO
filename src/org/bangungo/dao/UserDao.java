package org.bangungo.dao;

import java.util.List;
import org.bangungo.model.User;

public interface UserDao {

    public void saveUser(User user);

    public User getNamaUser(String username);

    public void updateUserPassword(String username, String password);

    public List<User> getAllUser();

    public void deleteUser(User userName);
}
