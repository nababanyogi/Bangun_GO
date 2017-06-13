
package org.bangungo.dao;

import org.bangungo.model.Admin;
import org.bangungo.model.User;


public interface AdminDao {
    public void saveUser(User user);
    public void saveAdmin(Admin admin);
}
