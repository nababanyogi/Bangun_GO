package org.bangungo.dao.impl;

import java.util.List;
import org.bangungo.dao.UserDao;
import org.bangungo.model.Material;
import org.bangungo.model.User;
import org.bangungo.util.HibernateUtil;
import org.hibernate.Session;

//import org.inventori.model.User;
//import org.inventori.util.HibernateUtil;

/**
 *
 * @author Cindy Fransiska
 */
public class UserDaoImplHibernate implements UserDao {

    @Override
    public void saveUser(User user) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(user);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public User getNamaUser(String username) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        User user = (User) session.get(User.class, username);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return user;
    }

    @Override
    public void updateUserPassword(String username, String password) {
        for (User u : getAllUser()) {
            if (u.getUserName().equals(username)) {
                Session session = HibernateUtil.getSession();
                session.getTransaction().begin();
                u.setPassword(password);
                session.update(u);
                session.getTransaction().commit();
                HibernateUtil.closeSession();
                break;
            }
        }

    }

    @Override
    public List<User> getAllUser() {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<User> users = session.createCriteria(User.class).list();
        session.getTransaction().commit();
        return users;

    }

    @Override
    public void deleteUser(User userName) {
        for (User user : getAllUser()) {
            if (user.getUserName().equalsIgnoreCase(userName.getUserName())) {
                Session session = HibernateUtil.getSession();
                session.getTransaction().begin();
                session.delete(user);
                session.getTransaction().commit();
                HibernateUtil.closeSession();
                break;
            } else {
                System.out.println("Failed to Delete!");
            }
        }
    }    
    
}
