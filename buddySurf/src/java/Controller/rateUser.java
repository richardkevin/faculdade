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
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author richard
 */
@WebServlet(name = "rateUser", urlPatterns = {"/rateUser"})
public class rateUser extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/rateUser.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            int type = Integer.parseInt(request.getParameter("type"));
            String description = request.getParameter("description");
            int stars = Integer.parseInt(request.getParameter("rate"));

            Session session = HibernateSessionFactory.getSession();

            Rating r = new Rating();
            r.setType(type);
            r.setDescription(description);
            r.setStars(stars);

            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(r);
            tx.commit();
            session.flush();
            session.close();
            request.getRequestDispatcher("/thanks_redirect.jsp").forward(request, response);
    }
}
