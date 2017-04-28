/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buddysurf;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author richard
 */
public class BuddySurf {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();


        User u = new User();
        u.setName("richard");
        u.setUsername("rk");
        u.setPassword("123");
        u.setAge(26);
        u.setAddress("Rua vila aurora");
        u.setMax_guests(2);

        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(u);
        tx.commit();
        session.flush();

        session.close();
    }

}
