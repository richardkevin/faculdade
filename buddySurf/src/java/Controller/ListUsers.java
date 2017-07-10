package Controller;

import Model.Users;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "ListUsers", urlPatterns = {"/users"})
public class ListUsers extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/listUsers.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession httpSession = request.getSession(true);
        Session session = HibernateSessionFactory.getSession();
        Query query = session.getNamedQuery("Users.findAll");

        List<Users> listUsers = query.list();
        if (httpSession.getAttribute("user") != null) {
            Users user = (Users) httpSession.getAttribute("user");
            request.setAttribute("user", user);

            long userLoggedId = user.getId();
            listUsers = removeUserLogged(listUsers, userLoggedId);
        }

        request.setAttribute("listUsers", listUsers);
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private List<Users> removeUserLogged(List list, long userLoggedId) {
        for (Users user : (List<Users>) list) {
            if (user.getId() == userLoggedId ) {
                list.remove(user);
                break;
            }
        }
        return list;
    }
}
