package org.bangungo.dao.impl;

import java.util.List;
import org.bangungo.dao.LoginDao;
import org.bangungo.model.Admin;
import org.bangungo.model.Login;
import org.bangungo.model.User;
import org.bangungo.util.HibernateUtil;
import org.hibernate.Session;
//import org.inventori.dao.LoginDao;
//import org.inventori.model.Admin;
//import org.inventori.model.Login;
//import org.inventori.model.User;
//import org.inventori.util.HibernateUtil;

public class LoginDaoImplHibernate implements LoginDao {

    @Override
    public List<User> getAllUser() {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<User> users = session.createCriteria(User.class).list();
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return users;
    }

    @Override
    public List<Login> getAllLogin() {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Login> login = session.createCriteria(Login.class).list();
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return login;
    }

    @Override
    public List<Admin> getAllAdmin() {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Admin> admins = session.createCriteria(Admin.class).list();
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return admins;
    }

    @Override
    public boolean login(String username, String password, int penanda) {
        boolean login = false;

        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        if (penanda == 0) {
            for (User user : getAllUser()) {
                if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
                    login = true;
                    break;
                } else {
                    login = false;
                }
            }

        }
        if (penanda == 1) {
            for (Admin admin : getAllAdmin()) {
                if (admin.getUserNameAdmin().equals(username) && admin.getPassword().equals(password)) {
                    login = true;
                    break;
                } else {
                    login = false;
                }
            }
        }
        return login;
    }

    //new
//    @Override
//    public boolean loginAdmin(String username, String password) {
//        boolean login = false;
//        Session session = HibernateUtil.getSession();
//        session.getTransaction().begin();
//
//        for (Admin admin : getAllAdmin()) {
//            if (username.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
//                login = true;
//                break;
//            } else {
//                login = false;
//            }
//        }
//        return login;
//    }
    @Override
    public void saveAkunLogin(Login m) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(m);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public String getNama(String username, String password, int penanda) {
        String user = null;

        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();

        if (penanda == 0) {
            for (User users : getAllUser()) {
                if (users.getUserName().equals(username) && users.getPassword().equals(password)) {
                    user = users.getNamaUser();
                    break;
                } else {
                    user = null;
                }
            }

        }
        if (penanda == 1) {
            for (Admin admin : getAllAdmin()) {
                if (admin.getUserNameAdmin().equals(username) && admin.getPassword().equals(password)) {
                    user = admin.getNamaAdmin();
                    break;
                } else {
                    user = null;
                }
            }
        }
        return user;
    }

//    @Override
//    public String getNamaAdmin(String username, String password) {
//        String user = null;
//
//        Session session = HibernateUtil.getSession();
//        session.getTransaction().begin();
//
//        for (Admin admins : getAllAdmin()) {
//            if (admins.getUsername().equals(username) && admins.getPassword().equals(password)) {
//                user = admins.getUsername();
//                break;
//            } else {
//                user = null;
//            }
//        }
//        return user;
//    }
    @Override
    public void deleteLog(Login userName, int penanda) {
        for (Login login : getAllLogin()) {
            if (login.getUsername().equalsIgnoreCase(userName.getUsername()) && penanda == 0) {
                Session session = HibernateUtil.getSession();
                session.getTransaction().begin();
                session.delete(login);
                session.getTransaction().commit();
                HibernateUtil.closeSession();
                break;
            } else {
                System.out.println("Failed to Delete!");
            }
        }
        
    }
}
