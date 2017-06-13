
package org.bangungo.dao.impl;

import org.hibernate.Session;
import org.bangungo.dao.AdminDao;
import org.bangungo.model.Admin;
import org.bangungo.model.User;
import org.bangungo.util.HibernateUtil;


public class AdminDaoImplHibernate implements AdminDao {

    @Override
    public void saveUser(User user) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(user);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public void saveAdmin(Admin admin) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(admin);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }
    
}
