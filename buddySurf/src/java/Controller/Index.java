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
@WebServlet(name = "Index", urlPatterns = {"/"})
public class Index extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Session session = HibernateSessionFactory.getSession();
        Query query = session.getNamedQuery("Accommodation.findAll");
        request.setAttribute("accommodations", query.list());

        HttpSession httpSession = request.getSession(true);
        Users user = (Users) httpSession.getAttribute("user");
	if (user != null) {
            request.setAttribute("user", user);
        }

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
