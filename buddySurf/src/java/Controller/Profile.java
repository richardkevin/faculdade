package Controller;

import Model.Users;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author richard
 */
@WebServlet(name = "Profile", urlPatterns = {"/Profile", "/profile", "/profile/*"})
public class Profile extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/profile.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pathParam = request.getPathInfo();

        if (pathParam != null) {
            request.setAttribute("hideSidebar", true);
        }

        HttpSession httpSession = request.getSession(true);
        Users user = (Users) httpSession.getAttribute("user");
        if (user != null) {
            request.setAttribute("user", user);

            Session session = HibernateSessionFactory.getSession();
            long userId = user.getId();
            Query query = session.getNamedQuery("Rating.findByReceiver").setParameter("receiver_id", userId);
            request.setAttribute("rates", query.list());

            query = session.getNamedQuery("Rating.getReceiverAverage").setParameter("receiver_id", userId);
            request.setAttribute("userAverage", query.uniqueResult());

            query = session.getNamedQuery("Accommodation.findByOwnerId").setParameter("owner_id", userId);
            request.setAttribute("accommodations", query.list());
        }
        else {
            request.getRequestDispatcher("login.jsp").include(request, response);
        }
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
