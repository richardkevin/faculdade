package Controller;

import Model.Rating;
import Model.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author richard
 */
@WebServlet(name = "rateUser", urlPatterns = {"/rateUser"})
public class rateUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession(false);
	if (httpSession != null) {
            Users user = (Users) httpSession.getAttribute("user");
            request.setAttribute("user", user);
            Session session = HibernateSessionFactory.getSession();

            Query query = session.getNamedQuery("Users.findAll");
            List<Users> userList = query.list();
            long userId = user.getId();
            
            for (Users u : userList) {
                if (u.getId() == userId) {
                    userList.remove(u);
                    break;
                }
            }

            request.setAttribute("userList", userList);
        }

        request.getRequestDispatcher("/rateUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            Session session = HibernateSessionFactory.getSession();
            HttpSession httpSession = request.getSession(false);
            Users user_logged = (Users) httpSession.getAttribute("user");

            String description = request.getParameter("description");
            int type = Integer.parseInt(request.getParameter("type"));
            int stars = Integer.parseInt(request.getParameter("rate"));
            Long sender_id = user_logged.getId();
            Long receiver_id = Long.parseLong(request.getParameter("user_selected"));

            Query query = session.getNamedQuery("Users.findById");

            Users sender = (Users) query.setParameter("id", sender_id).uniqueResult();
            Users receiver = (Users) query.setParameter("id", receiver_id).uniqueResult();

            Rating r = new Rating();
            r.setType(type);
            r.setDescription(description);
            r.setStars(stars);
            r.setSender(sender);
            r.setReceiver(receiver);

            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(r);
            tx.commit();
            session.flush();
            session.close();
            request.getRequestDispatcher("/thanks_redirect.jsp").forward(request, response);
    }
}
