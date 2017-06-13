package org.bangungo.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Bangun Go
 */
public class HibernateUtil {

    private static final SessionFactory SESSION_FACORY = createSessionFactory();
    private static ThreadLocal<Session> session = new ThreadLocal<Session>();

    /**
     * kelas yang bertujuan mengatur eksekusi yang akan dijalankan ke dalam
     * database
     *
     * @return
     */
    public static SessionFactory createSessionFactory() {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties()).build()
        );
    }

    /**
     * membuka kelas agar akses fungsi-fungsi program dapat sinkron dengan
     * database
     *
     * @return
     */
    public static Session getSession() {
        session.set(SESSION_FACORY.openSession());
        return session.get();
    }

    /**
     * menutup kelas ketika fungsi yang dijalankan telah selesai agar tidak
     * terjadi error ataupun inputan yang sembarang tanpa proses
     */
    public static void closeSession() {
        Session s = session.get();
        if (s != null) {
            s.close();
            session.remove();
        }
    }
}
